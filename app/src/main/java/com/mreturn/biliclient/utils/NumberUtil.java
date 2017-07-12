package com.mreturn.biliclient.utils;

/**
 * Created by mReturn
 * on 2017/7/12.
 */

public class NumberUtil {

    public static String coverString(int num) {
        if (num < 10000) {
            return String.valueOf(num);
        }
        String unit = "万";
        double finalNum = num / 10000.0;
        String result = String.format("%." + 1 + "f", finalNum);
        return result + unit;
    }

    public static String coverString(String numStr) {
        int num = Integer.parseInt(numStr);
        return coverString(num);
    }
}
