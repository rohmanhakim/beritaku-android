package com.rohmanhakim.beritaku.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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

public class NewsDetailsActivity extends AppCompatActivity implements NewsDetailsView{

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

    NewsDetailsPresenter presenter;

    @Inject
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ((BeritakuApp) getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            id = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_ID);
            title = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_TITLE);
            author = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_AUTHOR);
            date = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_DATE);
            imageUrl = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_IMAGE_URL);
            source = bundle.getString(ConstantUtils.IntentKey.INTENT_KEY_SOURCE);
        }

        if(source.equals(ConstantUtils.NewsSource.NEWS_SOURCE_DETIK)){
            getSupportActionBar().setTitle("Detik.com");
        }

        textSource.setText(source);
        textTitle.setText(title);
        textAuthor.setText(author);
        textDate.setText(date);
        Glide.with(NewsDetailsActivity.this).load(imageUrl).into(imgCover);

        presenter = new NewsDetailsPresenter(dataManager,this);
        presenter.getNewsDetailsFromDetik(id);

    }

    @Override
    public void onFinishedLoadingNewsContent(String author, String content) {
        textAuthor.setText(author);
        textContent.setText(Html.fromHtml(content));
    }
}
