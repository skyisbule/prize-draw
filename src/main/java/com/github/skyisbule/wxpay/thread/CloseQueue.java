package com.github.skyisbule.wxpay.thread;

import com.github.skyisbule.wxpay.task.CloseTask;

import java.util.Comparator;
import java.util.LinkedList;

//到达时间自动开奖
public class CloseQueue {

    private static Integer tail = 0;
    private static LinkedList<CloseTask> closeQueue = new LinkedList<>();


    private static Integer nowTime(){
        return Integer.parseInt(String.valueOf(System.currentTimeMillis()).substring(0,10));
    }

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
        CloseTask task = closeQueue.get(0);
        if (task.closeTime<nowTime()){//代表过了开奖时间了
            System.out.println("队列检测到了自动开奖，返回实体。");
            closeQueue.remove(task);
            tail--;
            return task;
        }
        return null;
    }

    public static void show(){
        for (CloseTask task : closeQueue) {
            System.out.println("prizeId"+task.prizeId+"  time:"+task.closeTime);
        }
    }

    public static boolean isEmpty(){
        return closeQueue.isEmpty();
    }

}
