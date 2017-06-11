package com.example.sean.showpiecephotos.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sean.showpiecephotos.constants.Constants;
import com.example.sean.showpiecephotos.R;
import com.example.sean.showpiecephotos.ui.presenters.HomescreenPresenter;
import com.example.sean.showpiecephotos.ui.presenters.HomescreenPresenterImpl;
import com.example.sean.showpiecephotos.ui.views.HomescreenView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomescreenActivity extends AppCompatActivity implements HomescreenView {

    private HomescreenPresenter homescreenPresenter;

    @BindView(R.id.access_token)
    TextView mAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        ButterKnife.bind(this);
        mAccessToken.setText(getIntent().getExtras().getString(Constants.SHARED_PREFERENCE_TOKEN));
        homescreenPresenter = new HomescreenPresenterImpl(this, this);
        homescreenPresenter.populateUser();
        homescreenPresenter.getRecentPosts();
    }

    @Override
    public void loadUser() {
        // use eventbus to load this

    }

    @Override
    public void loadPosts() {

    }
}
