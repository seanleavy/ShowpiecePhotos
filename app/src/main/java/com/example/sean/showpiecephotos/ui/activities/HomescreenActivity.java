package com.example.sean.showpiecephotos.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sean.showpiecephotos.R;
import com.example.sean.showpiecephotos.constants.Constants;
import com.example.sean.showpiecephotos.events.RecentPostsEvent;
import com.example.sean.showpiecephotos.events.SelfUserEvent;
import com.example.sean.showpiecephotos.model.Pojo.self.Self;
import com.example.sean.showpiecephotos.ui.adapters.RecentPostsAdapter;
import com.example.sean.showpiecephotos.ui.presenters.HomescreenPresenter;
import com.example.sean.showpiecephotos.ui.presenters.HomescreenPresenterImpl;
import com.example.sean.showpiecephotos.ui.views.HomescreenView;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomescreenActivity extends AppCompatActivity implements HomescreenView {

    @BindView(R.id.recent_posts_recyclerview)
    RecyclerView recentPostsRecyclerView;

    @BindView(R.id.fullname)
    TextView fullName;

    @BindView(R.id.nickname)
    TextView nickName;

    @BindView(R.id.follows)
    TextView follows;

    @BindView(R.id.following)
    TextView following;

    @BindView(R.id.profile_pic)
    ImageView profilePic;

    private HomescreenPresenter homescreenPresenter;
    private RecentPostsAdapter recentMediaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        ButterKnife.bind(this);
        setUpRecyclerView();
        homescreenPresenter = new HomescreenPresenterImpl(this);
        homescreenPresenter.populateUser();
        homescreenPresenter.getRecentPosts();
    }

    private void setUpRecyclerView() {
        recentPostsRecyclerView.setLayoutManager(new LinearLayoutManager(recentPostsRecyclerView.getContext()));
        recentMediaAdapter = new RecentPostsAdapter(this);
        recentPostsRecyclerView.setAdapter(recentMediaAdapter);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_logout) {
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRecentPostsSuccessEvent(RecentPostsEvent recentPostsEvent) {
        recentMediaAdapter.add(recentPostsEvent.getRecentPosts());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserSelfSuccessEvent(SelfUserEvent selfUserEvent) {
        populateSelf(selfUserEvent.getSelfUser());
    }

    private void populateSelf(Self self) {
        fullName.setText(self.getData().getFullName());
        nickName.setText(self.getData().getUsername());
        following.setText(self.getData().getCounts().getFollows().toString());
        follows.setText(self.getData().getCounts().getFollowedBy().toString());
        Picasso.with(this).load(self.getData().getProfilePicture())
                .placeholder(android.R.mipmap.sym_def_app_icon)
                .error(R.mipmap.ic_launcher_round)
                .into(profilePic);
    }

    private void logout() {
        getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().remove(Constants.ACCESS_TOKEN).apply();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
