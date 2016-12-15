package com.wifihckppsshu.wifihack.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wifihckppsshu.wifihack.R;
import com.wifihckppsshu.wifihack.entity.WifiEntity;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WifiListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_wifi_item_info)
    TextView wifiInfoTextView;
    @BindView(R.id.list_wifi_item_connectionQuality)
    ImageView connectionQuality;

    private Random random;
    private int wifiIcons [] = new int[]{R.mipmap.ic_wifi_three_bars,R.mipmap.ic_wifi_four_bars};

    public WifiListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(WifiEntity wifiEntity) {
        itemView.setTag(wifiEntity);
        wifiInfoTextView.setText(wifiEntity.getInfo());
        random = new Random();
        connectionQuality.setImageResource(wifiIcons[random.nextInt(2)]);

    }
}
