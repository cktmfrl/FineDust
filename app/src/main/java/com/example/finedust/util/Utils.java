package com.example.finedust.util;

public class Utils {

    /**
     * 지수, 등급 (1 : 좋음, 2: 보통, 3: 나쁨, 4: 매우나쁨)
     * @param value
     * @return
     */
    public static String getDustGrade(String value) {
        int val = Integer.valueOf(value);

        switch (val) {
            case 1:
                return "좋음";
            case 2:
                return "보통";
            case 3:
                return "나쁨";
            case 4:
                return "매우나쁨";
            default:
                return "null";
        }
//        switch (val) {
//            case 1:
//                return "좋음 (" + value + ")";
//            case 2:
//                return "보통 (" + value + ")";
//            case 3:
//                return "나쁨 (" + value + ")";
//            case 4:
//                return "매우나쁨 (" + value + ")";
//            default:
//                return "null";
//        }
    }
}