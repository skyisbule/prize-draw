package com.github.skyisbule.wxpay.controller;

import com.github.skyisbule.wxpay.dao.PrizeDrawMapper;
import com.github.skyisbule.wxpay.domain.Award;
import com.github.skyisbule.wxpay.domain.Lucky;
import com.github.skyisbule.wxpay.domain.PrizeDraw;
import com.github.skyisbule.wxpay.domain.PrizeDrawExample;
import com.github.skyisbule.wxpay.service.PrizeDrawService;
import com.github.skyisbule.wxpay.service.UserSerivce;
import com.github.skyisbule.wxpay.task.CloseTask;
import com.github.skyisbule.wxpay.thread.CloseQueue;
import com.github.skyisbule.wxpay.vo.PrizeDrawVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 抽奖的type定义
 * 0：手动开奖
 * 1：自动开奖（按时间）
 * 2：按人数开奖
 * 3：活动
 * 4：广告
 */
@Api("抽奖模块")
@RequestMapping(value = "/prize",method = RequestMethod.POST)
@RestController
public class PrizeDrawController {

    @Autowired
    PrizeDrawService service;
    @Autowired
    UserSerivce userSerivce;
    @Autowired
    PrizeDrawMapper dao;

    private Integer StringfloatToInt(String fee){
        System.out.println(fee);
        if (fee.indexOf('.')<1)
            return Integer.parseInt(fee+"00");
        if (fee.length()-fee.indexOf('.')==2)
            fee =fee +"0";
        fee = fee.replace("-","");
        String start = fee.substring(0,fee.indexOf('.'));
        if (Integer.parseInt(start)>0){//说明总额大于0 起码是1块。。。那么直接删掉小数点就行了
            return Integer.parseInt(fee.replace(".",""));
        }else {//小于0  那么代表是几毛几分的格式
            fee = fee.substring(fee.indexOf('.')+1,fee.length());
            if(fee.startsWith("0")){
                fee = fee.substring(fee.length()-1,fee.length());
            }
            return Integer.parseInt(fee);
        }
    }

    /**
     * 这里的处理流程
     * 获取抽奖信息以及奖品信息
     * 过滤信息
     * 插入抽奖信息表
     * 插入奖品表
     */
    @ApiOperation(value = "创建一个抽奖，传抽奖信息以及，List<award>，使用json格式，例如:{\"PrizeDraw\":{xxx},\"awards\":[{xxx},{xxxx},{xxx}]}")
    @RequestMapping("/add")
    public synchronized String add(@RequestBody PrizeDrawVO vo){//修改一下请求参数的接收方式
        //todo:这里对发来的数据验证一下
        int totalCrash = 0; //代表这个抽奖总共需要送多少钱
        for (Award award : vo.awards) {
            if (award.getLuckyNum()<1)
                return "奖品的数目不合法,请重新输入.";
            if (award.getType()==1) {//这里前端拒绝传分为单位，所以这里需要改一下
                award.setTitle(this.StringfloatToInt(award.getTitle()).toString());
                totalCrash += Integer.parseInt(award.getTitle());//记录抽奖总额
            }
        }
        //这里验证一下用户的余额够不够支付现金红包
        if (totalCrash>userSerivce.getUserBalance(vo.prizeDraw.getUuid())){
            return "用户现金不足哦:(";
        }
        Integer prizeId = service.createPrize(vo.prizeDraw,vo.awards);
        if (prizeId!=0){//代表创建成功了  开始扣除用户的余额
            userSerivce.updateBalance(vo.prizeDraw.getUuid(),-totalCrash);
        }
        if (vo.prizeDraw.getType()==1){//代表按时间自动开奖，需要把开奖任务打入队列
            CloseTask task = new CloseTask();
            task.prizeId = prizeId;
            task.closeTime = Integer.parseInt(String.valueOf(vo.prizeDraw.getExpireTime().getTime()).substring(0,10));
            CloseQueue.add(task);
        }
        return prizeId==0?"error":prizeId.toString();
    }

    @ApiOperation("关闭一个抽奖，通过id")
    @RequestMapping("/close")
    public synchronized List<Lucky> close(int prizeId){
        if (service.isClosed(prizeId)){//如果已经关闭了
            return new ArrayList<Lucky>();
        }
        return service.closePrize(prizeId);
    }

    @ApiOperation("通过uuid获取用户所有发起的抽奖")
    @RequestMapping("/get-prize-by-uuid")
    public List<PrizeDraw> getPrizeDrawByUUid(String uuid){
        PrizeDrawExample e = new PrizeDrawExample();
        e.createCriteria()
                .andUuidEqualTo(uuid);
        return dao.selectByExample(e);
    }


    @ApiOperation("查看一个抽奖是否已经关闭")
    public String isClosed(int prizeId){
        return service.isClosed(prizeId)?"{\"msg\":\"true\"}":"{\"msg\":\"false\"}";
    }

    @ApiOperation("传抽奖的id，查看抽奖信息。")
    @RequestMapping("/get-by-prize-id")
    public PrizeDraw getById(int prizeId){
        return dao.selectByPrimaryKey(prizeId);
    }

    @GetMapping("/init-time-task")
    public String initTimeTask(){
        PrizeDrawExample e = new PrizeDrawExample();
        e.createCriteria()
                .andTypeEqualTo(1)
                .andIsClosedEqualTo(0);
        List<PrizeDraw> prizeDraws = dao.selectByExample(e);
        for (PrizeDraw prizeDraw : prizeDraws) {
            System.out.println("检测到定时任务：prizeId  "+prizeDraw.getPrizeId()+" title:"+prizeDraw.getTitle());
            CloseTask task = new CloseTask();
            task.prizeId   = prizeDraw.getPrizeId();
            String time    = String.valueOf(prizeDraw.getExpireTime().getTime()).substring(0,10);
            task.closeTime = Integer.parseInt(time);
            CloseQueue.add(task);
        }
        CloseQueue.show();
        return "ok";
    }

}
