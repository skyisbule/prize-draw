package com.github.skyisbule.wxpay.service;

import com.github.skyisbule.wxpay.dao.AwardMapper;
import com.github.skyisbule.wxpay.dao.PartakeMapper;
import com.github.skyisbule.wxpay.dao.PrizeDrawMapper;
import com.github.skyisbule.wxpay.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrizeDrawService {


    @Autowired
    PrizeDrawMapper prizeDrawDao;
    @Autowired
    AwardMapper awardDao;
    @Autowired
    PartakeMapper partakeDao;

    private int getMaxId(){
        Integer res = prizeDrawDao.getMaxId();
        if (res == null){
            res = 0;
        }
        return res;
    }

    @Transactional(rollbackFor = Exception.class , isolation = Isolation.REPEATABLE_READ)
    public Integer createPrize(PrizeDraw prizeDraw, List<Award> awards){
        Integer res;
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

    //关闭抽奖
    public List<Lucky> closePrize(int prizeId){
        //设置状态为为关闭
        PrizeDraw prizeDraw = new PrizeDraw();
        prizeDraw.setPrizeId(prizeId);
        prizeDraw.setIsClosed(1);
        prizeDrawDao.updateByPrimaryKeySelective(prizeDraw);
        //获取参与者们
        PartakeExample partakeExample = new PartakeExample();
        partakeExample.createCriteria().andPrizeIdEqualTo(prizeId);
        List<Partake> partakes = partakeDao.selectByExample(partakeExample);
        //获取所有奖品
        AwardExample awardExample = new AwardExample();
        awardExample.createCriteria().andPrizeIdEqualTo(prizeId);
        List<Award> awards = awardDao.selectByExample(awardExample);
        //生成处理结果
        return luckyMan(prizeId,partakes,awards);
    }

    public List<Lucky> luckyMan(int prizeId,List<Partake> partakes,List<Award> awards){
        PrizeDraw prizeDraw = prizeDrawDao.selectByPrimaryKey(prizeId);
        //0代表是实物抽奖
        if (prizeDraw.getType() == 0){
            return doRealObj(partakes,awards);
        }else{//现金抽奖
            return doCrash(partakes,awards);
        }
    }

    private List<Lucky> doRealObj(List<Partake> partakes,List<Award> awards){
        return new ArrayList<Lucky>();
    }

    private List<Lucky> doCrash(List<Partake> partakes,List<Award> awards){
        return new ArrayList<Lucky>();
    }

}
