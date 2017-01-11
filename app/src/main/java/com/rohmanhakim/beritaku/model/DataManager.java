package com.rohmanhakim.beritaku.model;

import com.rohmanhakim.beritaku.services.detik.DetikService;
import com.rohmanhakim.beritaku.services.detik.response.DetikNewsItem;
import com.rohmanhakim.beritaku.services.detik.response.NewsDetailsResponse;
import com.rohmanhakim.beritaku.services.detik.response.DetikNewsfeedResponse;
import com.rohmanhakim.beritaku.services.tribun.TribunService;
import com.rohmanhakim.beritaku.services.tribun.response.TribunNewsItem;
import com.rohmanhakim.beritaku.services.tribun.response.TribunNewsfeedResponse;
import com.rohmanhakim.beritaku.utils.ConstantUtils;
import com.rohmanhakim.beritaku.utils.ConverterUtils;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 17:30.
 */
@Singleton
public class DataManager {

    private DetikService detikService;
    private TribunService tribunService;

    @Inject
    public DataManager(DetikService detikService, TribunService tribunService){
        this.detikService = detikService;
        this.tribunService = tribunService;
    }

    public Observable<NewsItem> getDetikNewsfeed(){
        return detikService.getNewsfeed(1,1,2,1)
                .map(
                    new Func1<DetikNewsfeedResponse, List<DetikNewsItem>>() {
                        @Override
                        public List<DetikNewsItem> call(DetikNewsfeedResponse detikNewsfeedResponse) {
                            return detikNewsfeedResponse.item;
                        }
                    })
                .flatMap(new Func1<List<DetikNewsItem>, Observable<DetikNewsItem>>() {
                    @Override
                    public Observable<DetikNewsItem> call(List<DetikNewsItem> items) {
                        return Observable.from(items);
                    }
                })
                .map(new Func1<DetikNewsItem, NewsItem>() {
                    @Override
                    public NewsItem call(DetikNewsItem item) {
                        NewsItem newsItem = new NewsItem();
                        newsItem.id = item.link;
                        newsItem.title = item.title;
                        newsItem.summary = item.summary;
                        newsItem.author = item.reporter;
                        newsItem.date = item.date.publish;
                        newsItem.source = ConstantUtils.NewsSource.NEWS_SOURCE_DETIK;
                        newsItem.imageUrl = ConverterUtils.getDetikLargeCoverImage(item.images.cover);
                        return newsItem;
                    }
                })
                .filter(new Func1<NewsItem, Boolean>() {
                    @Override
                    public Boolean call(NewsItem newsItem) {
                        return !newsItem.date.isEmpty();
                    }
                });
    }

    public Observable<NewsDetails> getDetikNewsDetails(String url){
        return detikService.getNewsDetails(url)
                .map(new Func1<NewsDetailsResponse, NewsDetails>() {
                    @Override
                    public NewsDetails call(NewsDetailsResponse newsDetailsResponse) {
                        NewsDetails newsDetails = new NewsDetails();
                        newsDetails.content = newsDetailsResponse.content.data;
                        newsDetails.author = newsDetailsResponse.content.authors.reporter;
                        return newsDetails;
                    }
                });
    }

    public Observable<NewsItem> getTribunLatestNewsfeed(){
        return tribunService.getNews("list","getlatest","home","json",1,10,TribunService.username,TribunService.authkey)
                .map(new Func1<TribunNewsfeedResponse, List<TribunNewsItem>>() {
                    @Override
                    public List<TribunNewsItem> call(TribunNewsfeedResponse tribunNewsfeedResponse) {
                        return tribunNewsfeedResponse.latest.item;
                    }
                })
                .flatMap(new Func1<List<TribunNewsItem>, Observable<TribunNewsItem>>() {
                    @Override
                    public Observable<TribunNewsItem> call(List<TribunNewsItem> tribunNewsItems) {
                        return Observable.from(tribunNewsItems);
                    }
                })
                .map(new Func1<TribunNewsItem, NewsItem>() {
                    @Override
                    public NewsItem call(TribunNewsItem item) {
                        NewsItem newsItem = new NewsItem();
                        newsItem.id = item.guid;
                        newsItem.title = item.title;
                        newsItem.summary = item.description;
                        newsItem.date = item.pubDate;
                        newsItem.source = ConstantUtils.NewsSource.NEWS_SOURCE_TRIBUN;
                        newsItem.imageUrl = item.photo;
                        return newsItem;
                    }
                });
    }

    public Observable<NewsItem> getAllNewsfeed(){
        return Observable.merge(getDetikNewsfeed(),getTribunLatestNewsfeed());
    }
}
