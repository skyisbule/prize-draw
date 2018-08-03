package com.github.skyisbule.wxpay.controller;

import com.github.skyisbule.wxpay.dao.ActiveMapper;
import com.github.skyisbule.wxpay.domain.Active;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("活动的api")
@RestController
@RequestMapping(value = "/active",method = {RequestMethod.GET,RequestMethod.POST})
public class ActiveController {

    @Autowired
    ActiveMapper dao;

    @ApiOperation("添加一个活动")
    @RequestMapping("/add")
    public String add(Active active){
        return dao.insert(active)==1?"success":"error";
    }

}
