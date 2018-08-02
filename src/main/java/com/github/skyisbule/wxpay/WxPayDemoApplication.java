package com.github.skyisbule.wxpay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.github.skyisbule.wxpay.dao")
@SpringBootApplication
public class WxPayDemoApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(WxPayDemoApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(WxPayDemoApplication.class);
  }
}
