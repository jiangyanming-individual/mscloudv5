package com.atguigu.cloud.controller;

import com.atguigu.cloud.api.PayFeignApi;
import com.atguigu.cloud.common.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderGateWayController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/feign/pay/gateway/get/{id}")
    public ResultData getOrderById(@PathVariable("id") Integer id) {
        return payFeignApi.getPayById(id);
    }

    @GetMapping("/feign/pay/gateway/info")
    public ResultData getGateWayInfo(){
        return payFeignApi.getGatewayInfo();
    }
}
