package com.github.skyisbule.wxpay.controller;

import com.github.skyisbule.wxpay.dao.PrizeDrawMapper;
import com.github.skyisbule.wxpay.domain.Award;
import com.github.skyisbule.wxpay.domain.PrizeDraw;
import com.github.skyisbule.wxpay.service.PrizeDrawService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//抽奖模块
@Api("抽奖模块")
@RequestMapping(value = "/prize",method = {RequestMethod.GET,RequestMethod.POST})
@RestController
public class PrizeDrawController {

    @Autowired
    PrizeDrawService service;
    @Autowired
    PrizeDrawMapper dao;

    /**
     * 这里的处理流程
     * 获取抽奖信息以及奖品信息
     * 过滤信息
     * 插入抽奖信息表
     * 插入奖品表
     */
    @ApiOperation("创建一个抽奖")
    @RequestMapping("/add")
    public synchronized String add(PrizeDraw prizeDraw,
                                   @RequestParam("Awards") List<Award> awards){
        Integer prizeId = service.createPrize(prizeDraw,awards);
        //todo:这里对发来的数据验证一下
        return prizeId==0?"error":prizeId.toString();
    }

    @ApiOperation("传抽奖的id，查看抽奖信息。")
    @RequestMapping("/get-by-prize-id")
    public PrizeDraw getById(int id){
        return dao.selectByPrimaryKey(id);
    }

}
