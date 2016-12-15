package com.wifihckppsshu.wifihack.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wifihckppsshu.wifihack.R;
import com.wifihckppsshu.wifihack.activities.BaseFragmentActivity;
import com.wifihckppsshu.wifihack.activities.LoaderActivity;
import com.wifihckppsshu.wifihack.entity.WifiEntity;
import com.wifihckppsshu.wifihack.util.WifiHelper;
import com.wifihckppsshu.wifihack.views.WifiListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WifiListFragment extends Fragment implements WifiListAdapter.WifiItemClickedListener{

    @BindView(R.id.fragment_wifi_recyclerView)
    RecyclerView recyclerView;

    private WifiListAdapter adapter;
    private WifiHelper wifiHelper;
    private List<WifiEntity> wifiConnections;

    public static WifiListFragment newInstance(){
        return new WifiListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new WifiListAdapter(this,(BaseFragmentActivity) getActivity());
        wifiConnections = new ArrayList<>();
        wifiHelper = new WifiHelper(getActivity());
        wifiConnections.addAll(wifiHelper.getWifiConnections());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wifi, container, false);
        ButterKnife.bind(this, rootView);
        configureRecyclerView();
        adapter.setWifiConnections(wifiConnections);
        recyclerView.setAdapter(adapter);
        return rootView;
    }


    @Override
    public void onWifiItemClicked(WifiEntity wifiEntity) {
        Intent intent = new Intent(getActivity(), LoaderActivity.class);
        startActivity(intent);
    }


    public void configureRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
    }
}
