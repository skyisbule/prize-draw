package com.github.skyisbule.wxpay.controller;


import com.github.skyisbule.wxpay.dao.PartakeMapper;
import com.github.skyisbule.wxpay.domain.Partake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partake")
public class PartakeController {

    @Autowired
    PartakeMapper dao;

    @RequestMapping("/add")
    public String add(Partake partake){
        return 1==dao.insert(partake)?"success":"error";
    }

}
