package com.example.sean.showpiecephotos.model;


import com.example.sean.showpiecephotos.constants.Constants;
import com.example.sean.showpiecephotos.model.Pojo.recent.RecentPosts;
import com.example.sean.showpiecephotos.singletons.TokenSingleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public class InstagramPostApi {

    private interface InstagramRecentMediaService {
        @GET("users/self/media/recent")
        Observable<RecentPosts> getRecentMedia(@Query("access_token") String access_token);
    }

    private Observable<RecentPosts> recentMediaObservable = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InstagramRecentMediaService.class)
            .getRecentMedia(TokenSingleton.getInstance().getAccessToken())
            .cache();

    public Observable<RecentPosts> getRecentMediaObservable() {
        return recentMediaObservable;
    }
}
