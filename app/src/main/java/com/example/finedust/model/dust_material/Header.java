package com.example.finedust.model.dust_material;

public class Header {

    @com.squareup.moshi.Json(name = "resultMsg")
    private String resultMsg;
    @com.squareup.moshi.Json(name = "resultCode")
    private String resultCode;

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

}