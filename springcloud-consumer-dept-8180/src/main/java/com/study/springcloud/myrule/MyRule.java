package com.study.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {
    @Bean
    public IRule myConfigRule(){//注入的bean名字不能和类名一样
        return new MyRandomRule();//默认是轮询RandomRule,现在自定义为自己的
    }
    //@Bean
    //public IRule myConfig2Rule(){
    //    return new MyRandomRule();//默认是轮询RandomRule,现在自定义为自己的
    //}
}
