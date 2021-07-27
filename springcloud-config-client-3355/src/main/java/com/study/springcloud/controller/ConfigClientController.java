package com.study.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: arise
 * @Date: 2021/7/27 下午8:03
 * @Description: 自定义规则
 */
@RestController
public class ConfigClientController {
    @Value("${spring.application.name}")
    private String applicationName; //获取微服务名称
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer; //获取Eureka服务
    @Value("${server.port}")
    private String port; //获取服务端的端口号
    @RequestMapping("/config")
    public String getConfig(){
        return "applicationName:"+applicationName +
                "eurekaServer:"+eurekaServer +
                "port:"+port;
    }
}
