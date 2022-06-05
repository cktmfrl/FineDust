package com.example.finedust.data;

import android.content.Context;
import android.util.Log;

import com.example.finedust.model.FineDust;
import com.example.finedust.util.FineDustUtil;
import com.example.finedust.view.FineDustFragment;

import retrofit2.Callback;

public class LocationFineDustRepository implements FineDustRepository {

    private static final String TAG = LocationFineDustRepository.class.getSimpleName();

    private FineDustUtil mFineDustUtil;
    private String mCity;

    /**
     * 
     * @param city : 시/도
     */
    public LocationFineDustRepository(Context context, String city) {
        mFineDustUtil = new FineDustUtil(context);
        mCity = city;
    }

    @Override
    public boolean isAvailable() {
        if (mCity != null && !"".equals(mCity)) { // if (mLatitude != 0.0 && mLongitude != 0.0) {
            return true;
        }

        return false;
    }

    @Override
    public void getFineDustData(Callback<FineDust> callback) {
        int numOfRows = 2;
        int pageNo = 1;
        String sidoName = mCity; // "경기";
        String ver = "1.0";

        Log.d(TAG, "sidoName = " + sidoName);

        mFineDustUtil.getApi().getFineDust("json", numOfRows, pageNo, sidoName, ver).enqueue(callback);
    }

}
