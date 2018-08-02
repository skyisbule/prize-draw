package com.github.skyisbule.wxpay.controller;


import com.github.skyisbule.wxpay.dao.PartakeMapper;
import com.github.skyisbule.wxpay.dao.PrizeDrawMapper;
import com.github.skyisbule.wxpay.domain.Partake;
import com.github.skyisbule.wxpay.domain.PartakeExample;
import com.github.skyisbule.wxpay.domain.PrizeDraw;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("参与抽奖的接口")
@RestController
@RequestMapping("/partake")
public class PartakeController {

    @Autowired
    PartakeMapper dao;
    @Autowired
    PrizeDrawMapper prizeDrawDao;

    @ApiOperation("添加抽奖人")
    @RequestMapping("/add")
    public String add(Partake partake){
        PrizeDraw prizeDraw = prizeDrawDao.selectByPrimaryKey(partake.getPrizeId());
        if (prizeDraw.getType() ==1)
            return "抽奖已关闭";
        return 1==dao.insert(partake)?"success":"error";
    }

    @ApiOperation("通过抽奖id拿到参与抽奖的人")
    @RequestMapping("/get-by-prize-id")
    public List<Partake> getByPid(Integer prizeId){
        PartakeExample e = new PartakeExample();
        e.createCriteria()
                .andPrizeIdEqualTo(prizeId);
        return dao.selectByExample(e);
    }

}
