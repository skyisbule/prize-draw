package com.github.skyisbule.wxpay.service;

import com.github.skyisbule.wxpay.dao.AwardMapper;
import com.github.skyisbule.wxpay.dao.PrizeDrawMapper;
import com.github.skyisbule.wxpay.domain.Award;
import com.github.skyisbule.wxpay.domain.PrizeDraw;
import com.github.skyisbule.wxpay.domain.PrizeDrawExample;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PrizeDrawService {


    @Autowired
    PrizeDrawMapper prizeDrawDao;
    @Autowired
    AwardMapper awardDao;


    @Transactional(rollbackFor = Exception.class , isolation = Isolation.REPEATABLE_READ)
    public boolean createPrize( PrizeDraw prizeDraw, List<Award> awards){
        boolean res = true;
        try {
            prizeDrawDao.insert(prizeDraw);//创建抽奖
            PrizeDrawExample e = new PrizeDrawExample();
            e.createCriteria();
            Integer maxPrizeId = (int)prizeDrawDao.countByExample(e) + 1;
            //给awards设置id并批量插入.
            awards.forEach((award -> {
                award.setPrizeId(maxPrizeId);
                awardDao.insert(award);
            }));
        }catch (Exception e){
            res = false;
        }
        return res;
    }

}
