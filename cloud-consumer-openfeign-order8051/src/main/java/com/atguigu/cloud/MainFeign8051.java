package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //服务注册与发现开启+
@EnableFeignClients //开启OpenFeign的功能
public class MainFeign8051 {
    public static void main(String[] args) {
        SpringApplication.run(MainFeign8051.class,args);
    }
}