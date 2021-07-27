package com.study.springcloud;

import com.study.springcloud.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
//Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号
@EnableEurekaClient  //开启Eureka 客户端
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)//开启负载均衡,并指定自定义的规则
public class DeptConsumer_8180 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_8180.class);
    }
}
