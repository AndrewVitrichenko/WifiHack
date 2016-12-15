package com.wifihckppsshu.wifihack.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.wifihckppsshu.wifihack.R;
import com.wifihckppsshu.wifihack.fragments.WifiListFragment;


public class WifiListActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_list);
        getSupportActionBar().hide();
    }

    @Override
    protected Fragment createFragment() {
        return WifiListFragment.newInstance();
    }

}
