package com.github.skyisbule.wxpay.controller;

import com.github.skyisbule.wxpay.dao.AdvertAuthMapper;
import com.github.skyisbule.wxpay.dao.AdvertMapper;
import com.github.skyisbule.wxpay.domain.Advert;
import com.github.skyisbule.wxpay.domain.AdvertAuth;
import com.github.skyisbule.wxpay.domain.AdvertExample;
import com.github.skyisbule.wxpay.util.SecretKeyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("广告可以领取成功的鉴权类")
@RestController
@RequestMapping(value = "/auth",method = RequestMethod.POST)
public class AdvertAuthController {

    @Autowired
    AdvertAuthMapper AuthDao;
    @Autowired
    AdvertMapper     adverDao;

    /**
     * 具体工作流程
     * 用户创建广告后会得到一个唯一的appKey，
     * 用户在第三方的小程序或者网站中完成一定的任务后需要由第三方请求该api
     * 请求参数为appKey，返回结果为一个新的key。
     * 用户需要凭借此key来参与奖品的领取。
     * 示例返回：{"code": 200,"res": "sss"}
     */
    @ApiOperation("这是给第三方用户接入的api")
    @RequestMapping("/add")
    public String doAuth(String appKey){
        String successCode    = "200";
        String errorCode      = "400";
        String successContent = " ";
        String errorContent   = "appKey不存在，请联系管理员。";
        String result         = "";
        AdvertExample e = new AdvertExample();
        e.createCriteria()
                .andSecretKeyEqualTo(appKey);
        try {
            List<Advert> adverts = adverDao.selectByExample(e);
            Advert advert = adverts.get(0);
            String key    = advert.getSecretKey();
            if (key.equals(appKey)){//鉴权成功
                String newKey = SecretKeyUtil.buildKey();
                AdvertAuth auth = new AdvertAuth();
                auth.setPrizeId(advert.getPrizeId());
                auth.setIsClose(0);
                auth.setReceiveKey(newKey);
                //插入鉴权库
                AuthDao.insert(auth);
                result = "{\"code\":"+successCode+",\"res\":\""+newKey+"\"}";
            }
        }catch (Exception exc){
            result = "{\"code\":"+errorCode+",\"res\":\""+errorContent+"\"}";
        }
        return result;
    }

}
