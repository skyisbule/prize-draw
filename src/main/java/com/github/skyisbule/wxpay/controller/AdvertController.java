package com.github.skyisbule.wxpay.controller;

import com.github.skyisbule.wxpay.dao.AdvertMapper;
import com.github.skyisbule.wxpay.domain.Advert;
import com.github.skyisbule.wxpay.util.SecretKeyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("处理广告的api")
@RestController
@RequestMapping(value = "/advert",method = RequestMethod.POST)
public class AdvertController {

    @Autowired
    AdvertMapper advertDao;

    @ApiOperation("添加一个广告,添加成功返回8位字符的key，你需要将它渲染给前端商户，否则返回error")
    @RequestMapping("/add")
    public String add(Advert advert){
        //这里生成一下随机的key
        String key = SecretKeyUtil.buildKey();
        advert.setSecretKey(key);
        return advertDao.insert(advert)==1?key:"error";
    }

    @ApiOperation("通过广告的id删除一个广告")
    @RequestMapping("/delete-by-id")
    public String delete(Integer advertId){
        return advertDao.deleteByPrimaryKey(advertId)==1?"success":"error";
    }


}
