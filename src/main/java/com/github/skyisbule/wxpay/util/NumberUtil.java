package com.github.skyisbule.wxpay.util;

public class NumberUtil {

    public static String fen2yuan(String fen){
        int crash = Integer.parseInt(fen);
        if (crash<10)
            return "0.0"+crash;
        if (crash<100)
            return "0."+crash;
        return String.valueOf(crash/100)+"."+String.valueOf(crash%100);
    }


}
