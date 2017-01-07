package com.rohmanhakim.beritaku;

import android.app.Application;

import com.rohmanhakim.beritaku.deps.AppComponent;
import com.rohmanhakim.beritaku.deps.AppModule;
import com.rohmanhakim.beritaku.deps.DaggerAppComponent;
import com.rohmanhakim.beritaku.deps.NetworkModule;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 16:44.
 */
public class BeritakuApp extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        setAppComponent(DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build());
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
