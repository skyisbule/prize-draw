package com.github.skyisbule.wxpay.dao;

import com.github.skyisbule.wxpay.domain.Recharge;
import com.github.skyisbule.wxpay.domain.RechargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RechargeMapper {
    long countByExample(RechargeExample example);

    int deleteByExample(RechargeExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Recharge record);

    int insertSelective(Recharge record);

    List<Recharge> selectByExample(RechargeExample example);

    Recharge selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Recharge record, @Param("example") RechargeExample example);

    int updateByExample(@Param("record") Recharge record, @Param("example") RechargeExample example);

    int updateByPrimaryKeySelective(Recharge record);

    int updateByPrimaryKey(Recharge record);
}