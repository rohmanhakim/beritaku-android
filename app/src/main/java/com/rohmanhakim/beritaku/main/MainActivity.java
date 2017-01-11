package com.rohmanhakim.beritaku.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rohmanhakim.beritaku.BeritakuApp;
import com.rohmanhakim.beritaku.R;
import com.rohmanhakim.beritaku.custom.RecyclerItemClickListener;
import com.rohmanhakim.beritaku.details.NewsDetailsActivity;
import com.rohmanhakim.beritaku.model.DataManager;
import com.rohmanhakim.beritaku.model.NewsItem;
import com.rohmanhakim.beritaku.utils.ConstantUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView{

    @Inject
    DataManager dataManager;

    NewsItemAdapter newsItemAdapter;

    MainPresenter mainPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.rv_newsfeed)
    RecyclerView rvNewsfeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BeritakuApp) getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        newsItemAdapter = new NewsItemAdapter(new ArrayList<NewsItem>());
        rvNewsfeed.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvNewsfeed.setAdapter(newsItemAdapter);
        rvNewsfeed.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, NewsDetailsActivity.class);
                intent.putExtra(ConstantUtils.IntentKey.INTENT_KEY_ID,(((NewsItemAdapter) rvNewsfeed.getAdapter()).getNewsItems().get(position).id));
                intent.putExtra(ConstantUtils.IntentKey.INTENT_KEY_TITLE,((NewsItemAdapter) rvNewsfeed.getAdapter()).getNewsItems().get(position).title);
                intent.putExtra(ConstantUtils.IntentKey.INTENT_KEY_SOURCE,((NewsItemAdapter) rvNewsfeed.getAdapter()).getNewsItems().get(position).source);
                intent.putExtra(ConstantUtils.IntentKey.INTENT_KEY_AUTHOR,((NewsItemAdapter) rvNewsfeed.getAdapter()).getNewsItems().get(position).author);
                intent.putExtra(ConstantUtils.IntentKey.INTENT_KEY_DATE,((NewsItemAdapter) rvNewsfeed.getAdapter()).getNewsItems().get(position).date);
                intent.putExtra(ConstantUtils.IntentKey.INTENT_KEY_IMAGE_URL,((NewsItemAdapter) rvNewsfeed.getAdapter()).getNewsItems().get(position).imageUrl);
                startActivity(intent);
            }
        }));

        mainPresenter = new MainPresenter(dataManager,this);

        mainPresenter.fetchNews();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_detik) {
            // Handle the detik.com action
        } else {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFinishLoadingNews(NewsItem newsItem) {
        ((NewsItemAdapter) rvNewsfeed.getAdapter()).add(newsItem);
    }
}
