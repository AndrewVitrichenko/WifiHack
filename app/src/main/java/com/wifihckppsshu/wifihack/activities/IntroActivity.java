package com.wifihckppsshu.wifihack.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wifihckppsshu.wifihack.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class IntroActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
    }

    @OnClick(R.id.button_start)
    public void startWifiActivity(){
        Intent intent = new Intent(this,WifiListActivity.class);
        startActivity(intent);
    }
}
