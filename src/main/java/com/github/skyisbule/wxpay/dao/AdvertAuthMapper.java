package com.github.skyisbule.wxpay.dao;

import com.github.skyisbule.wxpay.domain.AdvertAuth;
import com.github.skyisbule.wxpay.domain.AdvertAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertAuthMapper {
    long countByExample(AdvertAuthExample example);

    int deleteByExample(AdvertAuthExample example);

    int deleteByPrimaryKey(Integer authid);

    int insert(AdvertAuth record);

    int insertSelective(AdvertAuth record);

    List<AdvertAuth> selectByExample(AdvertAuthExample example);

    AdvertAuth selectByPrimaryKey(Integer authid);

    int updateByExampleSelective(@Param("record") AdvertAuth record, @Param("example") AdvertAuthExample example);

    int updateByExample(@Param("record") AdvertAuth record, @Param("example") AdvertAuthExample example);

    int updateByPrimaryKeySelective(AdvertAuth record);

    int updateByPrimaryKey(AdvertAuth record);
}