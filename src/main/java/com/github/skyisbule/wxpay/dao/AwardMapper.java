package com.github.skyisbule.wxpay.dao;

import com.github.skyisbule.wxpay.domain.Award;
import com.github.skyisbule.wxpay.domain.AwardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwardMapper {
    long countByExample(AwardExample example);

    int deleteByExample(AwardExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Award record);

    int insertSelective(Award record);

    List<Award> selectByExample(AwardExample example);

    Award selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Award record, @Param("example") AwardExample example);

    int updateByExample(@Param("record") Award record, @Param("example") AwardExample example);

    int updateByPrimaryKeySelective(Award record);

    int updateByPrimaryKey(Award record);
}