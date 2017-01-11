package com.rohmanhakim.beritaku.services.tribun;

import android.content.Context;

import com.google.gson.Gson;
import com.rohmanhakim.beritaku.services.tribun.response.TribunNewsfeedResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/10/17 16:51.
 */
public interface TribunService {
    String BASE_URL = "http://api.tribunnews.com/";
    String username = "app";
    String authkey = "a37a6cd34d32a69354e86ea5a1a1d4f2";

    @GET("external/")
    Observable<TribunNewsfeedResponse> getNews(
            @Query("type") String type,
            @Query("command") String command,
            @Query("kanal") String kanal,
            @Query("format") String format,
            @Query("page") int page,
            @Query("limit") int limit,
            @Query("username") String username,
            @Query("authkey") String authkey
    );

    class Builder {
        public static TribunService build(Context context, Gson gson){

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new okhttp3
                    .OkHttpClient
                    .Builder()
                    .addInterceptor(logging)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(TribunService.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(TribunService.class);
        }
    }
}
