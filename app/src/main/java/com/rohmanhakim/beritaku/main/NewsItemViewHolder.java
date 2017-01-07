package com.rohmanhakim.beritaku.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rohmanhakim.beritaku.R;
import com.rohmanhakim.beritaku.model.NewsItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 19:18.
 */
public class NewsItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_cover)
    ImageView imgCover;

    @BindView(R.id.text_newsfeed_title)
    TextView textNewsfeedTitle;

    @BindView(R.id.text_newsfeed_source)
    TextView textNewsfeedSource;

    @BindView(R.id.text_newsfeed_date)
    TextView textNewsfeedDate;

    @BindView(R.id.text_newsfeed_summary)
    TextView textNewsfeedSummary;

    Context context;

    public NewsItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        this.context = itemView.getContext();
    }

    public void bindNewsItem(NewsItem newsItem){
        Glide.with(context).load(newsItem.imageUrl).into(imgCover);
        textNewsfeedTitle.setText(newsItem.title);
        textNewsfeedSource.setText(newsItem.source);
        textNewsfeedDate.setText(newsItem.date);
        textNewsfeedSummary.setText(newsItem.summary);
    }
}
