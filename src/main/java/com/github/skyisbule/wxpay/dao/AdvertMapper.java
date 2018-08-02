package com.github.skyisbule.wxpay.dao;

import com.github.skyisbule.wxpay.domain.Advert;
import com.github.skyisbule.wxpay.domain.AdvertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertMapper {
    long countByExample(AdvertExample example);

    int deleteByExample(AdvertExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Advert record);

    int insertSelective(Advert record);

    List<Advert> selectByExample(AdvertExample example);

    Advert selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Advert record, @Param("example") AdvertExample example);

    int updateByExample(@Param("record") Advert record, @Param("example") AdvertExample example);

    int updateByPrimaryKeySelective(Advert record);

    int updateByPrimaryKey(Advert record);
}