package com.github.skyisbule.wxpay.dao;

import com.github.skyisbule.wxpay.domain.GetMoney;
import com.github.skyisbule.wxpay.domain.GetMoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GetMoneyMapper {
    long countByExample(GetMoneyExample example);

    int deleteByExample(GetMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GetMoney record);

    int insertSelective(GetMoney record);

    List<GetMoney> selectByExample(GetMoneyExample example);

    GetMoney selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GetMoney record, @Param("example") GetMoneyExample example);

    int updateByExample(@Param("record") GetMoney record, @Param("example") GetMoneyExample example);

    int updateByPrimaryKeySelective(GetMoney record);

    int updateByPrimaryKey(GetMoney record);
}