package com.example.sean.showpiecephotos.ui.activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sean.showpiecephotos.R;
import com.example.sean.showpiecephotos.constants.Constants;
import com.example.sean.showpiecephotos.events.RecentPostsEvent;
import com.example.sean.showpiecephotos.events.SelfUserEvent;
import com.example.sean.showpiecephotos.model.Pojo.user.InstagramUser;
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

    @OnClick(R.id.loadDataButton) void load() {
        homescreenPresenter.populateUser();
        homescreenPresenter.getRecentPosts();
    }

    private HomescreenPresenter homescreenPresenter;
    private RecentPostsAdapter recentPostsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        ButterKnife.bind(this);
        setUpRecyclerView();
        homescreenPresenter = new HomescreenPresenterImpl(this);
    }

    private void setUpRecyclerView() {
        recentPostsRecyclerView.setLayoutManager(new LinearLayoutManager(recentPostsRecyclerView.getContext()));
        recentPostsAdapter = new RecentPostsAdapter(this);
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
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserSelfSuccessEvent(SelfUserEvent selfUserEvent) {
        populateSelf(selfUserEvent.getSelfUser());
    }

    private void populateSelf(InstagramUser self) {
        fullName.setText(self.getData().getFullName());
        nickName.setText(self.getData().getUsername());
        following.setText(self.getData().getCounts().getFollows().toString());
        follows.setText(self.getData().getCounts().getFollowedBy().toString());
        Picasso.with(this).load(self.getData().getProfilePicture())
                .placeholder(android.R.mipmap.sym_def_app_icon)
                .error(R.mipmap.ic_launcher_round)
                .into(profilePic);
    }
}
