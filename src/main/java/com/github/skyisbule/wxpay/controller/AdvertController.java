package com.github.skyisbule.wxpay.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("处理广告的api")
@RestController
@RequestMapping(value = "/advert",method = {RequestMethod.GET,RequestMethod.POST})
public class AdvertController {
}
