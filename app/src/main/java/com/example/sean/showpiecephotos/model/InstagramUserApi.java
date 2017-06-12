package com.example.sean.showpiecephotos.model;

import com.example.sean.showpiecephotos.constants.Constants;
import com.example.sean.showpiecephotos.model.Pojo.user.InstagramUser;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public class InstagramUserApi {

    private interface InstagramUserService {
        @GET("users/self/")
        Observable<InstagramUser> getUserSelf(@Query("access_token") String access_token);
    }

    //needs api key for a start
    private Observable<InstagramUser> userObservable = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InstagramUserService.class)
            .getUserSelf("1491562952.65fd82d.c25001c90509456ab4ae74b4cfbdc249")
            .cache();

    public Observable<InstagramUser> getUserObservable() {
        return userObservable;
    }
}
