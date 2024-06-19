package com.atguigu.cloud.api;

import com.atguigu.cloud.common.ResultData;
import com.atguigu.cloud.fallback.PayFeignSentinelFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//FeignClient 接口
@FeignClient(value = "nacos-payment-provider",fallback = PayFeignSentinelFallBack.class)
public interface PayFeignSentinelApi {
    //接口
    @GetMapping("/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);

}
