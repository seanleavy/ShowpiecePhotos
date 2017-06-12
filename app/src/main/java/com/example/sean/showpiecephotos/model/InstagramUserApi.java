package com.example.sean.showpiecephotos.model;

import com.example.sean.showpiecephotos.constants.Constants;
import com.example.sean.showpiecephotos.model.Pojo.self.Self;
import com.example.sean.showpiecephotos.singletons.TokenSingleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public class InstagramUserApi {

    private interface InstagramUserService {
        @GET("users/self/")
        Observable<Self> getUserSelf(@Query("access_token") String access_token);
    }

    private Observable<Self> userObservable = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InstagramUserService.class)
            .getUserSelf(TokenSingleton.getInstance().getAccessToken())
            .cache();

    public Observable<Self> getUserObservable() {
        return userObservable;
    }
}
