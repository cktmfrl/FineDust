package com.example.finedust.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GeoUtil {

    private static final String TAG = GeoUtil.class.getSimpleName();

    public interface GeoUtilListener {
        /**
         *
         * @param addr : {"주소", "시/도"} ( Ex : {"서울특별시 종로구 삼청로", "서울시"} )
         * @param lat : 위도
         * @param lng : 경도
         */
        void onSuccess(String[] addr, double lat, double lng);

        void onError(String message);
    }

    public static void getLocationFromName(Context context, final String city, final GeoUtilListener listener) {
        Geocoder geocoder = new Geocoder(context);

        List<Address> addresses = new ArrayList<>();
        try {
            addresses = geocoder.getFromLocationName(city, 1);
            if (addresses.size() > 0) {
                double lat = addresses.get(0).getLatitude();
                double lng = addresses.get(0).getLongitude();
                listener.onSuccess(null, lat, lng);
            } else {
                listener.onError("주소 결과가 없습니다");
            }
        } catch (IOException e) {
            listener.onError(e.getMessage());
        }
    }

    public static void getFromLocation(Context context, final double latitude, final double longitude, final GeoUtilListener listener) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = new ArrayList<>();

        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0); // countryCode=KR,countryName=대한민국,admin=시/도,sub-admin=null,locality=시,thoroughfare=동,postalCode=번지,feature=상세주소
                //Log.d(TAG, "Address = " + address);
                //String addrStr = address.getAddressLine(0); // 전체 주소

                String sido = address.getAdminArea(); // 시/도 (Ex. 서울시, 경기도, ...)
                String gugun = address.getLocality(); // 구/군
                String dong = address.getThoroughfare(); // 동

                String[] result = new String[2];
                result[0] = sido + " " + gugun + " " + dong;
                result[1] = sido.length() > 2 ? sido.substring(0, 2) : sido;
                Log.d(TAG, Arrays.toString(result));

                listener.onSuccess(result, 0, 0);
            } else {
                listener.onError("현재위치에서 검색된 주소 결과가 없습니다");
            }
        } catch (IOException e) {
            listener.onError("Geocoder 서비스 사용불가"); // 네트워크 문제
        } catch (IllegalArgumentException e) {
            listener.onError("잘못된 GPS 좌표");
        }
    }

}
