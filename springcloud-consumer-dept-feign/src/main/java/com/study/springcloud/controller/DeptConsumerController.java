package com.study.springcloud.controller;

import com.study.springcloud.pojo.Dept;
import com.study.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {
    @Autowired
    private DeptClientService deptClientService;

    /**
     * 消费方添加部门信息
     *
     * @param dept
     * @return
     */
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return deptClientService.addDept(dept);
    }

    /**
     * 消费方根据id查询部门信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.queryById(id);
    }

    /**
     * 消费方查询部门信息列表
     *
     * @return
     */
    @RequestMapping("/consumer/dept/queryAll")
    public List<Dept> list() {
        return deptClientService.queryAll();
    }
}
//Feign和Ribbon二者对比，前者显现出面向接口编程特点，代码看起来更清爽，而且Feign调用方式更符合我们之前在做SSM或者SprngBoot项目时，Controller层调用Service层的编程习惯！
////理解::消费者不应该有service层
////RestTemplate 供我们直接调用
//@Autowired
//private RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法,简单的restful服务模板
//
////private static final String REST_URL_PREFIX = "http://localhost:8001";
//private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";
//@RequestMapping("/consumer/dept/add")
//public boolean add(Dept dept) {
//    // postForObject(服务提供方地址(接口),参数实体,返回类型.class)
//    return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
//}
//@RequestMapping("/consumer/dept/get/{id}")
//public Dept get(@PathVariable("id") Long id) {
//    return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
//}
//@RequestMapping("/consumer/dept/queryAll")
//public List<Dept> getAll() {
//    return restTemplate.getForObject(REST_URL_PREFIX + "/dept/queryAll",List.class);
//}
