package com.rohmanhakim.beritaku.deps;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rohmanhakim.beritaku.model.DataManager;
import com.rohmanhakim.beritaku.services.detik.DetikService;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 16:38.
 */
@Module
public class NetworkModule {
    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Gson providesGson(){
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public OkHttpClient providesOkHttpClient3() {
        int timeout = 2;
        return new okhttp3.OkHttpClient.Builder()
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public DetikService providesDetikService(Context context, Gson gson){
        return DetikService.Builder.build(context,gson);
    }
}
