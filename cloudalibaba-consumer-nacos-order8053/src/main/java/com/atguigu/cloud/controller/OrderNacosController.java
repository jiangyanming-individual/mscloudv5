package com.atguigu.cloud.controller;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    //读取服务地址：
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("/consumer/pay/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String res= restTemplate.getForObject(serviceUrl + "/pay/nacos/"+id, String.class);
        return  res + "\t"+ "我是OrderNacosController83调用者。。。。。。";
    }
}
