package com.github.skyisbule.wxpay.thread;

import com.github.skyisbule.wxpay.task.CloseTask;

import java.util.ArrayList;
import java.util.Comparator;

//到达时间自动开奖
public class CloseQueue {

    private static Integer tail = 0;
    private static ArrayList<CloseTask> closeQueue = new ArrayList<>();

    public static void add(CloseTask task){
        tail++;
        closeQueue.add(task);
    }

    private static void sort(){
        closeQueue.sort(Comparator.comparingInt(o -> o.closeTime));
    }

    private static CloseTask take(){
        tail--;
        return closeQueue.get(tail);
    }

    private static boolean isEmpty(){
        return closeQueue.isEmpty();
    }
}
