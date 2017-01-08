package com.rohmanhakim.beritaku.details;

import android.text.Html;
import android.util.Log;

import com.rohmanhakim.beritaku.model.DataManager;
import com.rohmanhakim.beritaku.model.NewsDetails;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/8/17 11:43.
 */
public class NewsDetailsPresenter {

    private DataManager dataManager;
    private NewsDetailsView view;

    public NewsDetailsPresenter(DataManager dataManager, NewsDetailsView view){
        this.dataManager = dataManager;
        this.view = view;
    }

    public void getNewsDetailsFromDetik(String url){
        dataManager.getDetikNewsDetails(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsDetails>() {
                    @Override
                    public void onCompleted() {
                        Log.d("getDetikDetails","Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("getDetikDetails",e.getMessage());
                    }

                    @Override
                    public void onNext(NewsDetails newsDetails) {
                        view.onFinishedLoadingNewsContent(newsDetails.author,newsDetails.content);
                    }
                });
    }
}
