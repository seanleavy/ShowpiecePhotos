package com.example.sean.showpiecephotos.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sean.showpiecephotos.R;
import com.example.sean.showpiecephotos.events.RecentPostsEvent;
import com.example.sean.showpiecephotos.ui.adapters.RecentPostsAdapter;
import com.example.sean.showpiecephotos.ui.presenters.HomescreenPresenter;
import com.example.sean.showpiecephotos.ui.presenters.HomescreenPresenterImpl;
import com.example.sean.showpiecephotos.ui.views.HomescreenView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomescreenActivity extends AppCompatActivity implements HomescreenView {

    @BindView(R.id.recent_posts_recyclerview)
    RecyclerView recentPostsRecyclerView;

    private HomescreenPresenter homescreenPresenter;
    private RecentPostsAdapter recentPostsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        ButterKnife.bind(this);
//        mAccessToken.setText(getIntent().getExtras().getString(Constants.SHARED_PREFERENCE_TOKEN));
        setUpRecyclerView();
        homescreenPresenter = new HomescreenPresenterImpl(this);
        homescreenPresenter.populateUser();
        homescreenPresenter.getRecentPosts();
    }

    private void setUpRecyclerView() {
        recentPostsRecyclerView.setLayoutManager(new LinearLayoutManager(recentPostsRecyclerView.getContext()));
        recentPostsAdapter = new RecentPostsAdapter();
        recentPostsRecyclerView.setAdapter(recentPostsAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRecentPostsSuccessEvent(RecentPostsEvent recentPostsEvent) {
        recentPostsAdapter.addPost(recentPostsEvent.getRecentPosts());
        Toast.makeText(this, "event caught", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadUser() {
    }

    @Override
    public void loadPosts() {
    }
}
