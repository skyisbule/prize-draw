package com.github.skyisbule.wxpay.controller;

import com.github.skyisbule.wxpay.dao.UserMapper;
import com.github.skyisbule.wxpay.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserMapper dao;

    @ApiOperation("创建一个用户信息")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String doRegister(User user){
        String resultContent;
        user.setBalance(0);
        try {
            dao.insert(user);
            resultContent = "success";
        }catch (Exception e){
            resultContent = "error:"+e.getMessage();
        }
        return resultContent;
    }

    @ApiOperation("更新用户信息")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String doupdate(User user){
        if (user.getUuid()==null)
            return "用户id为空";
        user.setBalance(null);
        dao.updateByPrimaryKey(user);
        return "更新成功";
    }

}
