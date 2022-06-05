package com.example.finedust.view;

import com.example.finedust.model.FineDust;


public interface FineDustContract {
    interface View {
        void showFineDustResult(FineDust dust);

        void showLoadError(String message);

        void loadingStart();

        void loadingEnd();

        void reload(String city);
    }

    interface UserActionsListener {
        void loadFineDustData();
    }
}
