package com.rohmanhakim.beritaku.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohmanhakim.beritaku.R;
import com.rohmanhakim.beritaku.model.NewsItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 19:17.
 */
public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemViewHolder> {

    private List<NewsItem> newsItems = new ArrayList<>();

    public NewsItemAdapter(List<NewsItem> newsItems){
        super();
        this.newsItems = newsItems;
    }

    @Override
    public NewsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_newsfeed_item, parent, false);
        return new NewsItemViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(NewsItemViewHolder holder, int position) {
        NewsItem newsItem = newsItems.get(position);
        holder.bindNewsItem(newsItem);
    }

    @Override
    public int getItemCount() {
        return getNewsItems().size();
    }

    public void add(NewsItem newsItem){
        this.newsItems.add(newsItem);
        this.notifyDataSetChanged();
    }

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }
}


