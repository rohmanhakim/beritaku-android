package com.rohmanhakim.beritaku.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rohmanhakim.beritaku.BeritakuApp;
import com.rohmanhakim.beritaku.R;
import com.rohmanhakim.beritaku.model.DataManager;
import com.rohmanhakim.beritaku.model.NewsDetails;
import com.rohmanhakim.beritaku.utils.ConstantUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.text_newsfeed_title)
    TextView textTitle;

    @BindView(R.id.text_newsfeed_author)
    TextView textAuthor;

    @BindView(R.id.text_newsfeed_date)
    TextView textDate;

    @BindView(R.id.img_cover)
    ImageView imgCover;

    @BindView(R.id.text_newsfeed_content)
    TextView textContent;

    @BindView(R.id.text_newsfeed_source)
    TextView textSource;

    String id;
    String title;
    String author;
    String date;
    String imageUrl;
    String source;

    @Inject
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ((BeritakuApp) getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            id = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_ID);
            title = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_TITLE);
            author = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_AUTHOR);
            date = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_DATE);
            imageUrl = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_IMAGE_URL);
            source = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_SOURCE);
        }

        textSource.setText(source);
        textTitle.setText(title);
        textAuthor.setText(author);
        textDate.setText(date);
        Glide.with(NewsDetailsActivity.this).load(imageUrl).into(imgCover);

        dataManager.getDetikNewsDetails(id)
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
                        textAuthor.setText(newsDetails.author);
                        textContent.setText(newsDetails.content);
                    }
                });
    }
}
