package com.github.skyisbule.wxpay.dao;

import com.github.skyisbule.wxpay.domain.PrizeDraw;
import com.github.skyisbule.wxpay.domain.PrizeDrawExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrizeDrawMapper {
    long countByExample(PrizeDrawExample example);

    int deleteByExample(PrizeDrawExample example);

    int deleteByPrimaryKey(Integer prizeId);

    int insert(PrizeDraw record);

    int insertSelective(PrizeDraw record);

    List<PrizeDraw> selectByExample(PrizeDrawExample example);

    PrizeDraw selectByPrimaryKey(Integer prizeId);

    int updateByExampleSelective(@Param("record") PrizeDraw record, @Param("example") PrizeDrawExample example);

    int updateByExample(@Param("record") PrizeDraw record, @Param("example") PrizeDrawExample example);

    int updateByPrimaryKeySelective(PrizeDraw record);

    int updateByPrimaryKey(PrizeDraw record);
}