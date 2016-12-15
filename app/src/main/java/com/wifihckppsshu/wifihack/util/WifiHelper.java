package com.wifihckppsshu.wifihack.util;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import com.wifihckppsshu.wifihack.entity.WifiEntity;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class WifiHelper {

    private WifiManager wifiManager;

    public WifiHelper(Context context) {
        this.wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    public List<WifiEntity> getWifiConnections() {
        List<WifiEntity> wifiConnections = new ArrayList<>();
        WifiEntity wifiEntity;
        String wifiConnectionInfo;

        if (!wifiManager.isWifiEnabled()){
            return getRandomConnections();
        }

        wifiManager.startScan();
        List<ScanResult> results = wifiManager.getScanResults();

        if (results == null){
            return getRandomConnections();
        } else {
            for (ScanResult result : results) {
                wifiConnectionInfo = result.SSID + "\n" + result.capabilities;
                wifiEntity = new WifiEntity(wifiConnectionInfo);
                wifiConnections.add(wifiEntity);
            }
        }

        return wifiConnections;
    }

    public List<WifiEntity> getRandomConnections() {
        List<WifiEntity> wifiConnections = new ArrayList<>();
        WifiEntity wifiEntity;
        String wifiConnectionInfo;
        Random random = new Random();
        int numberOfConnections = random.nextInt(7) + 2;
        for (int i = 0; i<numberOfConnections; i++){
            random = new Random();
            wifiConnectionInfo = RandomStringUtils.randomAlphanumeric(random.nextInt(4) + 5);
            wifiEntity = new WifiEntity(wifiConnectionInfo);
            wifiConnections.add(wifiEntity);
        }

        return wifiConnections;
    }

}
