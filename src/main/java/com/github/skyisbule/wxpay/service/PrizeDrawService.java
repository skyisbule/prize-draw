package com.github.skyisbule.wxpay.service;

import com.github.skyisbule.wxpay.dao.AwardMapper;
import com.github.skyisbule.wxpay.dao.LuckyMapper;
import com.github.skyisbule.wxpay.dao.PartakeMapper;
import com.github.skyisbule.wxpay.dao.PrizeDrawMapper;
import com.github.skyisbule.wxpay.domain.*;
import com.github.skyisbule.wxpay.util.RedPecket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class PrizeDrawService {

    @Autowired
    PrizeDrawMapper prizeDrawDao;
    @Autowired
    AwardMapper awardDao;
    @Autowired
    PartakeMapper partakeDao;
    @Autowired
    UserSerivce userSerivce;
    @Autowired
    LuckyMapper luckyDao;

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

    /**
     * 这里是关闭抽奖的处理流程
     *
     */
    public List<Lucky> luckyMan(int prizeId,List<Partake> partakes,List<Award> awards){
        PrizeDraw prizeDraw = prizeDrawDao.selectByPrimaryKey(prizeId);

        ArrayList<Lucky> luckyMans = new ArrayList<>();

        Collections.shuffle(partakes); //一堆用户id
        Collections.shuffle(awards);  //一堆奖品

        Integer awardSize = awards.size() - 1;


        awards.forEach(award -> {//遍历一下奖品
            Integer awardNow  = 0;
            if (award.getType()==0){//如果奖品是实物
                for (int i = 0;i<award.getLuckyNum();i++){
                    if (awardNow>awardSize) break;//这里判断下还有没有人
                    Partake partake = partakes.get(awardNow);
                    Lucky luckyMan = new Lucky();
                    luckyMan.setAwardId(award.getAid());
                    luckyMan.setAwardNum(1);
                    this.setLuckyManInfo(partake,luckyMan);
                    luckyMans.add(luckyMan);
                    awardNow++;
                }
            }

            if (award.getType()==1){//这里代表现金红包
                for (int i =0 ;i<award.getLuckyNum();i++){
                    if (awardNow>awardSize) break;//这里判断下还有没有人
                    int redPacketIndex = 0;
                    ArrayList<Integer> redPackets = RedPecket.build(award.getLuckyNum(),award.getLuckyNum());
                    Partake partake = partakes.get(awardNow);
                    Lucky luckyMan = new Lucky();
                    luckyMan.setAwardId(award.getAid());
                    luckyMan.setAwardNum(redPackets.get(redPacketIndex));
                    this.setLuckyManInfo(partake,luckyMan);
                    awardNow++;
                }
            }

        });

        Integer totalAwardsNum  = 0;                 //奖品的个数
        Integer totalLuckyNum   = luckyMans.size(); //得奖的人数。。
        for (Award award : awards) totalAwardsNum+=award.getLuckyNum();

        if (totalAwardsNum>totalLuckyNum){//假设说奖品的个数比中奖人数多，需要将现金奖品退回账户。
            HashMap<Integer,Integer> luckyHashMap = new HashMap<>();
            for (Lucky luckyMan : luckyMans) { //  <奖品id，获奖的人数>;
                if (!luckyHashMap.containsKey(luckyMan.getAwardId())){
                    luckyHashMap.put(luckyMan.getAwardId(),0);
                }
                Integer num = luckyHashMap.get(luckyMan.getAwardId())+1;
                luckyHashMap.put(luckyMan.getAwardId(),num);
            }
            awards.forEach(award -> {
                if (award.getType()==1){
                    if (award.getLuckyNum()>luckyHashMap.get(award.getAid())){//说明没领完  要把剩下的钱退给创建抽奖的人
                        Integer realNum = 0;//实际领的钱
                        for (Lucky luckyMan : luckyMans) {
                            realNum += luckyMan.getAwardNum();
                        }
                        if (award.getLuckyNum()>realNum){//这里把多余的没有领的钱退回给原先的人。
                            userSerivce.updateBalance(prizeDraw.getUuid(),award.getLuckyNum()-realNum);
                        }
                    }
                }
            });
        }
        luckyMans.forEach(lucky -> luckyDao.insert(lucky));//批量入库
        return luckyMans;
    }

    private List<Lucky> doRealObj(List<Partake> partakes,List<Award> awards){
        return new ArrayList<Lucky>();
    }

    private List<Lucky> doCrash(List<Partake> partakes,List<Award> awards){
        return new ArrayList<Lucky>();
    }

    private Lucky setLuckyManInfo(Partake partake,Lucky lucky){
        lucky.setHeadPic(partake.getHeadPic());
        lucky.setNickName(partake.getNickName());
        lucky.setUuid(partake.getUuid());
        return lucky;
    }

}
