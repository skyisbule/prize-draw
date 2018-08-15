package com.github.skyisbule.wxpay.controller;

import com.github.skyisbule.wxpay.dao.AwardMapper;
import com.github.skyisbule.wxpay.domain.Award;
import com.github.skyisbule.wxpay.domain.AwardExample;
import com.github.skyisbule.wxpay.util.NumberUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("奖品相关的api")
@RestController
@RequestMapping(value = "/award",method = RequestMethod.POST)
public class AwardController {

    @Autowired
    AwardMapper awardDao;

    @ApiOperation("通过id拿到抽奖的奖品信息")
    @RequestMapping("/get-by-prize-id")
    public List<Award> getByPrizeId(Integer prizeId){
        AwardExample e = new AwardExample();
        e.createCriteria()
                .andPrizeIdEqualTo(prizeId);
        List<Award> awards = awardDao.selectByExample(e);
        for (Award award : awards) {
            if (award.getType()==1){//现金抽奖
                String yuan = NumberUtil.fen2yuan(award.getTitle());
                award.setTitle("现金红包："+yuan+"元");
            }
        }
        return awards;
    }

}
