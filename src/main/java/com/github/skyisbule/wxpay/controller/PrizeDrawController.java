package com.github.skyisbule.wxpay.controller;

import com.github.skyisbule.wxpay.domain.Award;
import com.github.skyisbule.wxpay.domain.PrizeDraw;
import com.github.skyisbule.wxpay.service.PrizeDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//抽奖模块
@RequestMapping("/prize")
@RestController
public class PrizeDrawController {

    @Autowired
    PrizeDrawService service;

    /**
     * 这里的处理流程
     * 获取抽奖信息以及奖品信息
     * 过滤信息
     * 插入抽奖信息表
     * 插入奖品表
     */
    @RequestMapping("/add")
    public synchronized String add(@RequestBody PrizeDraw prizeDraw,
                                   @RequestBody List<Award> awards){
        return service.createPrize(prizeDraw,awards)?"success":"error";
    }

}
