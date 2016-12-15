package com.wifihckppsshu.wifihack.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.wifihckppsshu.wifihack.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WifiTitleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.wifi_list_title)
    ImageView title;

    public WifiTitleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        title.setImageResource(R.drawable.wifi_list_title);
    }

}
