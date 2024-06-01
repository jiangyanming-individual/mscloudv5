package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //服务注册与发现开启
public class Main8050 {
    public static void main(String[] args) {
        SpringApplication.run(Main8050.class,args);
    }

}