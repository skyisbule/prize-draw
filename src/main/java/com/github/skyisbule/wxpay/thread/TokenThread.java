package com.github.skyisbule.wxpay.thread;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class TokenThread extends Thread{

    String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx0979e5108bb19647&secret=8495795411ce539c2d04eb0693fd228c";

    public void run(){
        while (true){
            String result = HttpUtil.get(url);
            JSONObject jsonObject = JSONUtil.parseObj(result);
            TokenData.accessToken = jsonObject.get("access_token").toString();
            Integer time =Integer.parseInt(jsonObject.get("access_token").toString());
            try {
                Thread.sleep((long)60*60 *1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
