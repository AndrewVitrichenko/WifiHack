package com.wifihckppsshu.wifihack.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import com.wifihckppsshu.wifihack.R;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyConnectFlag;
import com.wifihckppsshu.wifihack.views.custom_loader.CircleLoader;
import com.wifihckppsshu.wifihack.views.custom_loader.CircleLoaderAnimation;

import java.util.Hashtable;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoaderActivity extends AppCompatActivity implements TJPlacementListener,TJConnectListener {

    @BindView(R.id.circleLoader)
    CircleLoader circleLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        ButterKnife.bind(this);
        getSupportActionBar().hide();


        /**
         * Custom loader with animation
         */
        CircleLoaderAnimation animation = new CircleLoaderAnimation(circleLoader, 360);
        animation.setDuration(7000);
        circleLoader.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                showDialog();
                circleLoader.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * Connecting to Tapjoy
     */
    public void connectToTapjoy() {
        Hashtable<String, Object> connectFlags = new Hashtable<String, Object>();
        connectFlags.put(TapjoyConnectFlag.ENABLE_LOGGING, "true");

        Tapjoy.connect(getApplicationContext(), getString(R.string.sdk_key), connectFlags, new TJConnectListener() {
            @Override
            public void onConnectSuccess() {
                Toast.makeText(LoaderActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                TJPlacement placement = new TJPlacement(getApplicationContext(), "OfferWall", LoaderActivity.this);
                placement.requestContent();

            }

            @Override
            public void onConnectFailure() {
                Toast.makeText(LoaderActivity.this, "Fail! Try again!", Toast.LENGTH_SHORT).show();
            }
        });
        Tapjoy.setDebugEnabled(true);

    }


    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.download_app)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        connectToTapjoy();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Tapjoy.onActivityStart(this);
    }

    @Override
    protected void onStop() {
        Tapjoy.onActivityStop(this);
        super.onStop();
    }

    @Override
    public void onRequestSuccess(TJPlacement tjPlacement) {
    }

    @Override
    public void onRequestFailure(TJPlacement tjPlacement, TJError tjError) {
    }

    @Override
    public void onContentReady(TJPlacement tjPlacement) {
        tjPlacement.showContent();
    }

    @Override
    public void onContentShow(TJPlacement tjPlacement) {
    }

    @Override
    public void onContentDismiss(TJPlacement tjPlacement) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_success)
                .setMessage(R.string.dialog_offer_complete)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        startActivity(new Intent(getApplicationContext(),WifiListActivity.class));
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        showDialog();
                    }
                });
        builder.create().show();
    }

    @Override
    public void onPurchaseRequest(TJPlacement tjPlacement, TJActionRequest tjActionRequest, String s) {
    }

    @Override
    public void onRewardRequest(TJPlacement tjPlacement, TJActionRequest tjActionRequest, String s, int i) {
    }

    @Override
    public void onConnectSuccess() {

    }

    @Override
    public void onConnectFailure() {

    }
}
