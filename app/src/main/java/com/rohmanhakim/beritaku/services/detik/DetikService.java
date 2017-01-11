package com.rohmanhakim.beritaku.services.detik;

import android.content.Context;
import android.util.Base64;

import com.google.gson.Gson;
import com.rohmanhakim.beritaku.services.detik.response.NewsDetailsResponse;
import com.rohmanhakim.beritaku.services.detik.response.DetikNewsfeedResponse;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 16:56.
 */
public interface DetikService {
    String BASE_URL = "http://android.detik.com/";
    String username = "detik";
    String password = "d3t1kc0m";
    int TIMEOUT = 2;

    @GET("api/newsfeed")
    Observable<DetikNewsfeedResponse> getNewsfeed(@Query("compress") int compress, @Query("min") int min, @Query("kanal") int kanal, @Query("page") int page);

    @GET("api/news_detail")
    Observable<NewsDetailsResponse> getNewsDetails(@Query("url") String url);

    class Builder {
        public static DetikService build(Context context, Gson gson){



            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            Interceptor headerInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Authorization", Util.buildAuth())
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            };

            OkHttpClient client = new okhttp3
                    .OkHttpClient
                    .Builder()
                    .addInterceptor(logging)
                    .addInterceptor(headerInterceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(DetikService.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(DetikService.class);
        }
    }

    class Util {
        public static String buildAuth(){
            String credentials = username + ":" + password;
            final String authorization = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
            return authorization;
        }
    }
}
