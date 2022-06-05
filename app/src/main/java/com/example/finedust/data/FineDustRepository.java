package com.example.finedust.data;

import com.example.finedust.model.FineDust;

import retrofit2.Callback;

public interface FineDustRepository {

    boolean isAvailable();

    void getFineDustData(Callback<FineDust> callback);
}
