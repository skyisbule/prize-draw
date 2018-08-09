package com.github.skyisbule.wxpay.thread;

import com.github.skyisbule.wxpay.domain.Lucky;

import java.util.concurrent.LinkedBlockingQueue;

//模板消息
public class MessageData {

    public static LinkedBlockingQueue<Lucky> messageQueue = new LinkedBlockingQueue<>();

}
