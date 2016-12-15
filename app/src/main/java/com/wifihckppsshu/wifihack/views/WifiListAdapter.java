package com.wifihckppsshu.wifihack.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wifihckppsshu.wifihack.R;
import com.wifihckppsshu.wifihack.activities.BaseFragmentActivity;
import com.wifihckppsshu.wifihack.entity.WifiEntity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;


public class WifiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private final int VIEW_TYPE_TITLE = 1;
    private final int VIEW_TYPE_BODY = 2;

    @Getter
    private List<WifiEntity> wifiConnections;

    private LayoutInflater inflater;
    private WifiItemClickedListener listener;


    public WifiListAdapter(WifiItemClickedListener listener, BaseFragmentActivity baseFragmentActivity) {
        this.listener = listener;
        inflater = baseFragmentActivity.getLayoutInflater();
        wifiConnections = new ArrayList<>();
    }


    public void setWifiConnections(List<WifiEntity> newWifiConnections) {
        wifiConnections.clear();
        wifiConnections.addAll(newWifiConnections);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View titleView = inflater.inflate(R.layout.list_item_title, parent, false);
        View listView = inflater.inflate(R.layout.list_wifi_item, parent, false);
        listView.setOnClickListener(this);

        if (viewType == VIEW_TYPE_TITLE) {
            return new WifiTitleViewHolder(titleView);
        } else {
            return new WifiListViewHolder(listView);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WifiTitleViewHolder) {
            WifiTitleViewHolder titleViewHolder = (WifiTitleViewHolder) holder;
            position--;
        } else if (holder instanceof WifiListViewHolder) {
            WifiListViewHolder listViewHolder = (WifiListViewHolder) holder;
            WifiEntity wifiEntity = wifiConnections.get(position);
            listViewHolder.populate(wifiEntity);
        }
    }

    @Override
    public int getItemCount() {
        return wifiConnections.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_TITLE;
        } else {
            return VIEW_TYPE_BODY;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getTag() instanceof WifiEntity) {
            WifiEntity wifiEntity = (WifiEntity) view.getTag();
            listener.onWifiItemClicked(wifiEntity);
        }
    }

    public interface WifiItemClickedListener {
        void onWifiItemClicked(WifiEntity wifiEntity);
    }
}
