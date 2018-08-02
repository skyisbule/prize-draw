package com.github.skyisbule.wxpay.dao;

import com.github.skyisbule.wxpay.domain.Partake;
import com.github.skyisbule.wxpay.domain.PartakeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PartakeMapper {
    long countByExample(PartakeExample example);

    int deleteByExample(PartakeExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Partake record);

    int insertSelective(Partake record);

    List<Partake> selectByExample(PartakeExample example);

    Partake selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Partake record, @Param("example") PartakeExample example);

    int updateByExample(@Param("record") Partake record, @Param("example") PartakeExample example);

    int updateByPrimaryKeySelective(Partake record);

    int updateByPrimaryKey(Partake record);
}