package com.example.sean.showpiecephotos.ui.presenters;


import android.util.Log;

import com.example.sean.showpiecephotos.events.ErrorEvent;
import com.example.sean.showpiecephotos.events.RecentPostsEvent;
import com.example.sean.showpiecephotos.events.SelfUserEvent;
import com.example.sean.showpiecephotos.model.InstagramPostApi;
import com.example.sean.showpiecephotos.model.InstagramUserApi;
import com.example.sean.showpiecephotos.model.Pojo.recent.RecentPosts;
import com.example.sean.showpiecephotos.model.Pojo.self.Self;
import com.example.sean.showpiecephotos.ui.views.HomescreenView;

import org.greenrobot.eventbus.EventBus;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class HomescreenPresenterImpl implements HomescreenPresenter {

    private HomescreenView homescreenView;
    private InstagramUserApi instagramUserApi;
    private InstagramPostApi instagramPostApi;

    public HomescreenPresenterImpl(HomescreenView homescreenView) {
        this.homescreenView = homescreenView;
        this.instagramUserApi = new InstagramUserApi();
        this.instagramPostApi = new InstagramPostApi();
    }

    @Override
    public void populateUser() {
        instagramUserApi.getUserObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Self>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        EventBus.getDefault().post(new ErrorEvent());
                        Log.e("InstagramUserApiError", e.getMessage());
                    }

                    @Override
                    public void onNext(Self instagramUser) {
                        EventBus.getDefault().post(new SelfUserEvent(instagramUser));
                    }
                });
    }

    @Override
    public void getRecentPosts() {
        instagramPostApi.getRecentMediaObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecentPosts>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        EventBus.getDefault().post(new ErrorEvent());
                        Log.e("InstagramPostApiError", e.getMessage());
                    }

                    @Override
                    public void onNext(RecentPosts instagramPosts) {
                        EventBus.getDefault().post(new RecentPostsEvent(instagramPosts));
                    }
                });
    }
}
