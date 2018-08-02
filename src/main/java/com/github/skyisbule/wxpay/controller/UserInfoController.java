package com.github.skyisbule.wxpay.controller;

import com.github.skyisbule.wxpay.dao.UserMapper;
import com.github.skyisbule.wxpay.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserMapper dao;

    @RequestMapping(value = "/register",method = {RequestMethod.GET,RequestMethod.POST})
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

}
