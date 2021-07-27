package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//
//@SpringBootApplication
////Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号
//@EnableEurekaClient  //开启Eureka 客户端
//@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)//开启负载均衡,并指定自定义的规则
@SpringBootApplication(scanBasePackages = {"com.study.springcloud.service", "com.study.springcloud"})
@EnableEurekaClient
// feign客户端注解,并指定要扫描的包以及配置接口DeptClientService
@EnableFeignClients(basePackages = {"com.study.springcloud"})
// 切记不要加这个注解，不然会出现404访问不到
//@ComponentScan("com.study.springcloud.service")
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class);
    }
}
