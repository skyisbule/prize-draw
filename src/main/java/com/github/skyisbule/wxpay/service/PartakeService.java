package com.github.skyisbule.wxpay.service;

import com.github.skyisbule.wxpay.dao.AwardMapper;
import com.github.skyisbule.wxpay.dao.PartakeMapper;
import com.github.skyisbule.wxpay.domain.Award;
import com.github.skyisbule.wxpay.domain.AwardExample;
import com.github.skyisbule.wxpay.domain.Partake;
import com.github.skyisbule.wxpay.domain.PartakeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartakeService {

    @Autowired
    AwardMapper awardDao;
    @Autowired
    PartakeMapper partakeDao;

    //拿到一个抽奖有多少个奖品
    public Integer getLuckyNumByPrizeId(Integer prizeId){
        int res = 0;
        AwardExample e = new AwardExample();
        e.createCriteria()
                .andPrizeIdEqualTo(prizeId);
        List<Award> awards = awardDao.selectByExample(e);
        for (Award award : awards) {
            res +=award.getLuckyNum();
        }
        return res;
    }

    //拿到已经有多少人参与了
    public Integer getPartakedNumByPrizeId(Integer prizeId){
        PartakeExample e = new PartakeExample();
        e.createCriteria()
                .andPrizeIdEqualTo(prizeId);
        return (int)partakeDao.countByExample(e);
    }

}
