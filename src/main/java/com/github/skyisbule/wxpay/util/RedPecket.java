package com.github.skyisbule.wxpay.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//红包算法
public class RedPecket {

    public static ArrayList<Integer> build(int totalMoney, int number){
        ArrayList<Integer> reslut = new ArrayList<>(number);
        float total = totalMoney/100;//红包总额
        float money;
        double min = 1;//最小红包
        double max;
        int i = 1;
        List<Float> math = new ArrayList<Float>();
        DecimalFormat df = new DecimalFormat("###.##");
        while (i < number) {
            max = total - min * (number - i);
            int k = (int)(number - i) / 2;
            if (number - i <= 2) k = number - i;
            max = max / k;
            money = (int) (min * 100 + Math.random() * (max * 100 - min * 100 + 1));
            money = (float)money / 100;
            money = Float.parseFloat(df.format(money));
            total=(int)(total*100 - money*100);
            total = total/100;
            math.add(money);
            i++;
            if (i == number) {
                math.add(total);
            }
        }

        math.forEach(aFloat -> {
            String  moneyStr = String.valueOf(aFloat);
            if (moneyStr.indexOf('.')+3>moneyStr.length()){
                moneyStr+="0";
            }
            String temp =moneyStr.replace(".","");
            reslut.add(Integer.parseInt(temp));
        });

        return reslut;
    }

}
