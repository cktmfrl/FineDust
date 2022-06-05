package com.example.finedust.util;

import com.example.finedust.model.FineDust;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FineDustApi {

    String BASE_URL = "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/";

    // 시도별 실시간 측정정보 조회 : getCtprvnRltmMesureDnsty
    // 대기질 예보통보 조회       : getMinuDustFrcstDspth
    // 초미세먼지 주간예보 조회    : getMinuDustWeekFrcstDspth

    // 시도별 실시간 측정정보 조회
    @GET("getCtprvnRltmMesureDnsty?serviceKey=aMz0EQZwrt65j1dF60nxBOtEzf6kAaHCvIlH5Vl1mmmwAcYQ6yBlIizaDACnPTFalRUzFRWU6dt0Oc8AXn80sQ%3D%3D")
    Call<FineDust> getFineDust(@Query("returnType") String returnType,
                               @Query("numOfRows") int numOfRows,
                               @Query("pageNo") int pageNo,
                               @Query("sidoName") String sidoName,
                               @Query("ver") String ver);

}
