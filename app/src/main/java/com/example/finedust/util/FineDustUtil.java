package com.example.finedust.util;

import android.content.Context;

import com.example.finedust.repository.FineDustService;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class FineDustUtil {

    private FineDustService mGetApi;

    public FineDustUtil(Context context) {

        // SSL 우회접속 시도 // 안전하지 않음으로 HTTPS를 통과합니다.

        //OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        OkHttpClient httpClient = SSLUtil.getUnsafeOkHttpClient().build();

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(FineDustService.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(httpClient)
                .build();

        // 인증서 정보로 SSL 접속 시도
        /*Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(FineDustApi.BASE_URL)
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())                  // Rxandroid
                .addConverterFactory(GsonConverterFactory.create())                         // JSON
                .client(new OkHttpClient.Builder()
                        .sslSocketFactory(SSLUtil.getPinnedCertSslSocketFactory(context))   //ssl
                        .hostnameVerifier(new NullHostNameVerifier())                       //ssl HostName Pass
                        .build())
                .build();*/

        mGetApi = mRetrofit.create(FineDustService.class);
    }

    public FineDustService getApi() {
        return mGetApi;
    }

    class NullHostNameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

}
