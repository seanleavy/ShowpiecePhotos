package com.example.sean.showpiecephotos.model;


import com.example.sean.showpiecephotos.constants.Constants;
import com.example.sean.showpiecephotos.model.Pojo.recentPosts.InstagramPost;
import com.example.sean.showpiecephotos.singletons.TokenSingleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public class InstagramPostApi {

    private interface InstagramRecentMediaService {
        @GET("users/self/media/recent")
        Observable<InstagramPost> getRecentMedia(@Query("access_token") String access_token);
    }

    private Observable<InstagramPost> recentMediaObservable = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InstagramRecentMediaService.class)
            .getRecentMedia(TokenSingleton.getInstance().getAccessToken())
            .cache();

    public Observable<InstagramPost> getRecentMediaObservable() {
        return recentMediaObservable;
    }
}
