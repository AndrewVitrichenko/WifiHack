package com.wifihckppsshu.wifihack.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.wifihckppsshu.wifihack.R;


public abstract class BaseFragmentActivity extends AppCompatActivity {

    protected FragmentManager fragmentManager;

    /**
     * Method for creating fragment
     *
     * @return created fragment
     */
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentManager = getSupportFragmentManager();


        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_wifi_list_fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.activity_wifi_list_fragment_container, fragment)
                    .commit();
        }

    }

}
