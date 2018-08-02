package com.github.skyisbule.wxpay.service;

import com.github.skyisbule.wxpay.dao.AwardMapper;
import com.github.skyisbule.wxpay.dao.PrizeDrawMapper;
import com.github.skyisbule.wxpay.domain.Award;
import com.github.skyisbule.wxpay.domain.PrizeDraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrizeDrawService {


    @Autowired
    PrizeDrawMapper prizeDrawDao;
    @Autowired
    AwardMapper awardDao;

    public int getMaxId(){
        Integer res = prizeDrawDao.getMaxId();
        if (res == null){
            res = 0;
        }
        return res;
    }

    @Transactional(rollbackFor = Exception.class , isolation = Isolation.REPEATABLE_READ)
    public Integer createPrize(PrizeDraw prizeDraw, List<Award> awards){
        Integer res = 0;
        try {
            prizeDrawDao.insert(prizeDraw);//创建抽奖
            Integer maxPrizeId = this.getMaxId() + 1;
            res = maxPrizeId;
            //给awards设置id并批量插入.
            awards.forEach(award -> {
                award.setPrizeId(maxPrizeId);
                awardDao.insert(award);
            });
        }catch (Exception e){
            res = 0;
        }
        return res;
    }

}
