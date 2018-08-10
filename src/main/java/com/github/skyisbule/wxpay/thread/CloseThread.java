package com.github.skyisbule.wxpay.thread;

import cn.hutool.http.HttpRequest;
import com.github.skyisbule.wxpay.task.CloseTask;

//定时任务，关闭定时的
public class CloseThread extends Thread{

    public void run(){

        while (true){
            CloseTask task = CloseQueue.take();
            if (task!=null){
                if (task.closeTime<(int)System.currentTimeMillis()){
                    HttpRequest
                            .post("http://127.0.0.1/prize/close")
                            .form("prizeId",task.prizeId)
                            .execute()
                            .body();
                }
            }
            try {
                Thread.sleep(10000);//10秒检查一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
