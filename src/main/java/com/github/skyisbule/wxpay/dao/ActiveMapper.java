package com.github.skyisbule.wxpay.dao;

import com.github.skyisbule.wxpay.domain.Active;
import com.github.skyisbule.wxpay.domain.ActiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActiveMapper {
    long countByExample(ActiveExample example);

    int deleteByExample(ActiveExample example);

    int deleteByPrimaryKey(Integer acid);

    int insert(Active record);

    int insertSelective(Active record);

    List<Active> selectByExample(ActiveExample example);

    Active selectByPrimaryKey(Integer acid);

    int updateByExampleSelective(@Param("record") Active record, @Param("example") ActiveExample example);

    int updateByExample(@Param("record") Active record, @Param("example") ActiveExample example);

    int updateByPrimaryKeySelective(Active record);

    int updateByPrimaryKey(Active record);
}