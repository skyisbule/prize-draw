package com.github.skyisbule.wxpay.controller;


import com.github.skyisbule.wxpay.dao.AdvertAuthMapper;
import com.github.skyisbule.wxpay.dao.PartakeMapper;
import com.github.skyisbule.wxpay.dao.PrizeDrawMapper;
import com.github.skyisbule.wxpay.domain.*;
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
    @Autowired
    AdvertAuthMapper authDao;

    @ApiOperation("添加抽奖人，参与抽奖,如果是参与广告抽奖的用户，需要额外传一个partakeKey做参与鉴权。")
    @RequestMapping("/add")
    public String add(Partake partake,String partakeKey){
        PrizeDraw prizeDraw = prizeDrawDao.selectByPrimaryKey(partake.getPrizeId());
        //先看看这个抽奖关闭了没
        if (prizeDraw.getIsClosed() ==1)
            return "抽奖已关闭:(";
        //可以抽就得先走鉴权，看看用户有没有权限参与这次抽奖。 ps:4为广告抽奖 需要鉴权
        if (prizeDraw.getType()==4){
            AdvertAuthExample e = new AdvertAuthExample();
            e.createCriteria()
                    .andPrizeIdEqualTo(partake.getPrizeId())
                    .andReceiveKeyEqualTo(partakeKey);
            List<AdvertAuth> auths = authDao.selectByExample(e);
            if (auths==null) return "领取失败，检查一下key有没有输错。";
            AdvertAuth auth = auths.get(0);
            if (auth.getIsClose()!=0) return "该key已被使用。";
            //走到这里说明是有效的   那么就把这个key删掉
            AdvertAuth closeKey = new AdvertAuth();
            closeKey.setIsClose(1);
            authDao.updateByExampleSelective(closeKey,e);
        }
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
