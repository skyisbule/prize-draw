package com.github.skyisbule.wxpay.controller;

import com.github.skyisbule.wxpay.dao.ActiveMapper;
import com.github.skyisbule.wxpay.domain.Active;
import com.github.skyisbule.wxpay.domain.ActiveExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这里的流程 暂定
 * 用户填写活动内容表单：标题 内容 --》缓存
 * 用户填写抽奖表单 创建一个抽奖 --》提交   获取prizeId
 * 执行回调  将prizeId关联进活动   提交
 * 收到success回调整个流程即为结束
 * 否则回滚
 */
@Api("活动的api")
@RestController
@RequestMapping(value = "/active",method = RequestMethod.POST)
public class ActiveController {

    @Autowired
    ActiveMapper dao;

    @ApiOperation("添加一个活动")
    @RequestMapping("/add")
    public String add(Active active){
        return dao.insert(active)==1?"success":"error";
    }

    @ApiOperation("删除一个活动")
    @RequestMapping("/delete-by-id")
    public String delete(Integer activeId){
        return dao.deleteByPrimaryKey(activeId)==1?"success":"error";
    }

    @ApiOperation("获得活动信息")
    @RequestMapping("/get-all")
    public List<Active> get(){
        ActiveExample e = new ActiveExample();
        e.setOrderByClause("acid desc");
        e.createCriteria();
        return dao.selectByExample(e);
    }

    @ApiOperation("通过id获得活动的详情信息")
    @RequestMapping("/get-by-id")
    public Active getId(int activeId){
        return dao.selectByPrimaryKey(activeId);
    }
}
