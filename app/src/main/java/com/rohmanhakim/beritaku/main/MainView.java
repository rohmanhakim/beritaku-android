package com.rohmanhakim.beritaku.main;

import com.rohmanhakim.beritaku.model.NewsItem;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 20:03.
 */
public interface MainView {
    void onFinishLoadingNews(NewsItem newsItem);
}
