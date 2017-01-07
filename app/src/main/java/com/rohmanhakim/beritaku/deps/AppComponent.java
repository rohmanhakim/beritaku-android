package com.rohmanhakim.beritaku.deps;

import com.rohmanhakim.beritaku.details.NewsDetailsActivity;
import com.rohmanhakim.beritaku.main.MainActivity;
import com.rohmanhakim.beritaku.model.DataManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 16:40.
 */
@Singleton
@Component(modules = { AppModule.class, NetworkModule.class })
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(NewsDetailsActivity newsDetailsActivity);
    DataManager dataManager();
}
