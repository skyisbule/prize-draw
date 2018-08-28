package com.github.skyisbule.wxpay.domain;

//支付的实体
public class PayResult {
    int    code   =  200;
    public String appId;
    public String timeStamp;
    public String nonceStr;
    public String prepayId;
    public String paySign;

    public static PayResult build(String str){
        PayResult result = new PayResult();
        result.appId = str.substring(str.indexOf("appId=")+6,str.indexOf(", timeStamp"));
        result.nonceStr = str.substring(str.indexOf("nonceStr=")+9,str.indexOf(", packageValue"));
        result.timeStamp = str.substring(str.indexOf("timeStamp=")+10,str.indexOf(", nonceStr"));
        result.prepayId  = str.substring(str.indexOf("prepay_id=")+10,str.indexOf(", signTy"));
        result.paySign   = str.substring(str.indexOf("paySign")+8,str.length()-1);
        return result;
    }

    public static PayResult buildError(){
        PayResult result = new PayResult();
        result.code = 400;
        return result;
    }

}
