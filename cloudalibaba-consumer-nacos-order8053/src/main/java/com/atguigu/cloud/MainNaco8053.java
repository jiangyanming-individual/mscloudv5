package com.atguigu.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MainNaco8053 {
    public static void main(String[] args) {
        SpringApplication.run(MainNaco8053.class,args);
    }
}