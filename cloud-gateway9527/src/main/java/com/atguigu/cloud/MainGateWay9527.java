package com.atguigu.cloud;


import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//开启服务注册与发现
public class MainGateWay9527 {
    public static void main(String[] args) {
        SpringApplication.run(MainGateWay9527.class, args);
    }
}