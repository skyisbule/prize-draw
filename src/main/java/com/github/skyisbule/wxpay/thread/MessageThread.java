package com.github.skyisbule.wxpay.thread;

import cn.hutool.http.HttpRequest;
import com.github.skyisbule.wxpay.domain.Lucky;

public class MessageThread extends Thread{

    private final String mesg_url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=";

    private String buildReqJson(Lucky luckyMan){
        String reqJson = "{\"touser\":\"OPENID\",\"template_id\":\"TEMPLATE_ID\",\"page\":\"index\",\"form_id\":\"FORMID\",\"data\":{\"keyword1\":{\"value\":\"您参与的抽奖已经开奖啦！\"},\"keyword2\":{\"value\":\"实物奖品由创建方领取，现金奖品的金额已打入您的账户。\"}},\"emphasis_keyword\":\"\"}";
        reqJson = reqJson.replace("OPENID",luckyMan.getUuid());//替换用户的openid
        reqJson = reqJson.replace("FORMID",luckyMan.getFormId());//替换formId
        //todo 这里要替换一下 index 用来做跳转
        return reqJson;
    }

    private void send(Lucky luckyMan){
        HttpRequest
                .post(mesg_url+TokenData.accessToken)
                .body(buildReqJson(luckyMan))
                .execute()
                .body();
    }

    public void run(){
        while (true){
            try {
                Lucky lucky = MessageData.messageQueue.take();//一直尝试取出数据
                this.send(lucky);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
