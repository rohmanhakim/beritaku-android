package com.rohmanhakim.beritaku.deps;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 16:37.
 */
@Module
public class AppModule {
    private final Context context;


    public AppModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Context providesContext(){
        return context;
    }
}
