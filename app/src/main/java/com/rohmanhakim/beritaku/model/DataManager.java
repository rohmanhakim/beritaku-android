package com.rohmanhakim.beritaku.model;

import com.rohmanhakim.beritaku.services.detik.DetikService;
import com.rohmanhakim.beritaku.services.detik.response.Item;
import com.rohmanhakim.beritaku.services.detik.response.NewsfeedResponse;
import com.rohmanhakim.beritaku.utils.ConverterUtils;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 17:30.
 */
@Singleton
public class DataManager {

    private DetikService detikService;

    @Inject
    public DataManager(DetikService detikService){
        this.detikService = detikService;
    }

    public Observable<NewsItem> getDetikNewsfeed(){
        return detikService.getNewsfeed(1,1,2,1)
                .map(
                    new Func1<NewsfeedResponse, List<Item>>() {
                        @Override
                        public List<Item> call(NewsfeedResponse newsfeedResponse) {
                            return newsfeedResponse.item;
                        }
                    })
                .flatMap(new Func1<List<Item>, Observable<Item>>() {
                    @Override
                    public Observable<Item> call(List<Item> items) {
                        return Observable.from(items);
                    }
                })
                .map(new Func1<Item, NewsItem>() {
                    @Override
                    public NewsItem call(Item item) {
                        NewsItem newsItem = new NewsItem();
                        newsItem.title = item.title;
                        newsItem.summary = item.summary;
                        newsItem.author = item.penulis;
                        newsItem.date = item.date.publish;
                        newsItem.source = "Detik";
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
}
