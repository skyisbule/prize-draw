package com.github.skyisbule.wxpay.auth;

import com.github.skyisbule.wxpay.dao.AdvertAuthMapper;
import com.github.skyisbule.wxpay.domain.AdvertAuth;
import com.github.skyisbule.wxpay.domain.AdvertAuthExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//用于确保不会生成重复的key
@Controller
public class AuthKeyCheck {

    @Autowired
    AdvertAuthMapper dao;

    public static HashSet<String> keySet = new HashSet<>();

    @RequestMapping("/authCheck/get-used-key")
    public Set doSet(){
        return keySet;
    }

    public void init(){
        AdvertAuthExample e = new AdvertAuthExample();
        e.createCriteria();
        List<AdvertAuth> auths = dao.selectByExample(e);
        for (AdvertAuth auth : auths) {
            keySet.add(auth.getReceiveKey());
        }
    }

    public static boolean Used(String key){
        return keySet.contains(key);
    }

}
