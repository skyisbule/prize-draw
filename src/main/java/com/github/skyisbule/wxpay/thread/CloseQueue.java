package com.github.skyisbule.wxpay.thread;

import com.github.skyisbule.wxpay.task.CloseTask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;

//到达时间自动开奖
public class CloseQueue {

    private static Integer tail = 0;
    private static LinkedList<CloseTask> closeQueue = new LinkedList<>();

    public static void add(CloseTask task){
        tail++;
        closeQueue.add(task);
        sort();
    }

    private static void sort(){
        closeQueue.sort(Comparator.comparingInt(o -> o.closeTime));
    }

    public static CloseTask take(){
        if (closeQueue.isEmpty())
            return null;
        Integer nowTime = (int)System.currentTimeMillis();
        CloseTask task = closeQueue.get(0);
        if (task.closeTime<nowTime){//代表过了开奖时间了
            closeQueue.remove(task);
            tail--;
            return task;
        }
        return null;
    }

    public static boolean isEmpty(){
        return closeQueue.isEmpty();
    }

}
