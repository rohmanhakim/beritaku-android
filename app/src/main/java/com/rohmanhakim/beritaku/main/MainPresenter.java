package com.rohmanhakim.beritaku.main;

import android.util.Log;

import com.rohmanhakim.beritaku.model.DataManager;
import com.rohmanhakim.beritaku.model.NewsItem;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 20:04.
 */
public class MainPresenter {

    DataManager dataManager;
    MainView view;

    public MainPresenter(DataManager dataManager, MainView view){
        this.dataManager = dataManager;
        this.view = view;
    }

    public void fetchNewsFromDetik(){
        dataManager.getDetikNewsfeed()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsItem>() {
                    @Override
                    public void onCompleted() {
                        Log.d("getDetikNews","Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("getDetikNews",e.getMessage());
                    }

                    @Override
                    public void onNext(NewsItem newsItem) {
                        view.onFinishLoadingNews(newsItem);
                    }
                });
    }
}
