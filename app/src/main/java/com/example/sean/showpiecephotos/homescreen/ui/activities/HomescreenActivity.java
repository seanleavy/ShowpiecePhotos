package com.example.sean.showpiecephotos.homescreen.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sean.showpiecephotos.Constants.Constants;
import com.example.sean.showpiecephotos.R;
import com.example.sean.showpiecephotos.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomescreenActivity extends AppCompatActivity {

    @BindView(R.id.access_token)
    TextView mAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        ButterKnife.bind(this);
        mAccessToken.setText(getIntent().getExtras().getString(Constants.SHARED_PREFERENCE_TOKEN));
    }
}
