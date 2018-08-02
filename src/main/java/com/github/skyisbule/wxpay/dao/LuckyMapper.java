package com.github.skyisbule.wxpay.dao;

import com.github.skyisbule.wxpay.domain.Lucky;
import com.github.skyisbule.wxpay.domain.LuckyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuckyMapper {
    long countByExample(LuckyExample example);

    int deleteByExample(LuckyExample example);

    int deleteByPrimaryKey(Integer lid);

    int insert(Lucky record);

    int insertSelective(Lucky record);

    List<Lucky> selectByExample(LuckyExample example);

    Lucky selectByPrimaryKey(Integer lid);

    int updateByExampleSelective(@Param("record") Lucky record, @Param("example") LuckyExample example);

    int updateByExample(@Param("record") Lucky record, @Param("example") LuckyExample example);

    int updateByPrimaryKeySelective(Lucky record);

    int updateByPrimaryKey(Lucky record);
}