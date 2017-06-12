package com.example.sean.showpiecephotos.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sean.showpiecephotos.constants.Constants;
import com.example.sean.showpiecephotos.singletons.TokenSingleton;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        if(preferences.contains(Constants.ACCESS_TOKEN)) {
            TokenSingleton.getInstance().setAccessToken(preferences.getString(Constants.ACCESS_TOKEN, ""));
            startActivity(new Intent(this, HomescreenActivity.class));
            finish();
        }
        else{
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}
