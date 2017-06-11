package com.example.sean.showpiecephotos.ui.presenters;


import android.content.Context;
import android.widget.Toast;

import com.example.sean.showpiecephotos.model.InstagramUserApi;
import com.example.sean.showpiecephotos.model.Pojo.user.InstagramUser;
import com.example.sean.showpiecephotos.ui.views.HomescreenView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class HomescreenPresenterImpl implements HomescreenPresenter {

    private HomescreenView homescreenView;
    private InstagramUserApi instagramUserApi;
    private Context context;

    public HomescreenPresenterImpl(HomescreenView homescreenView, Context context) {
        this.homescreenView = homescreenView;
        this.instagramUserApi = new InstagramUserApi();
        this.context = context;
    }

    @Override
    public void populateUser() {
        instagramUserApi.getUserObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<InstagramUser>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context, "ballsack", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(InstagramUser instagramUser) {
                        Toast.makeText(context, "RXHOLYFOOOK", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void getRecentPosts() {

    }
}
