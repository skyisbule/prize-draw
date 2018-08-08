package com.github.skyisbule.wxpay.util;

import com.github.skyisbule.wxpay.auth.AuthKeyCheck;

import java.util.Random;

//生成key的算法
public class SecretKeyUtil {

    private static String doBuild() {
        Random random = new Random();
        final String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        int length = 8;
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = SOURCES.charAt(random.nextInt(SOURCES.length()));
        }
        return new String(text);
    }

    public static String buildKey() {
        while (true){
            String res = doBuild();
            if (AuthKeyCheck.Used(res))
                res = doBuild();
            else
                return res;
        }


    }

}
