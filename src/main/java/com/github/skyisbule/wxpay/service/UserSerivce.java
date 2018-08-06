package com.github.skyisbule.wxpay.service;

import com.github.skyisbule.wxpay.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerivce {

    @Autowired
    UserMapper userDao;

    //更新余额
    public synchronized void updateBalance(String uuid,Integer crash){
        userDao.updateBalance(uuid,crash);
    }

}
