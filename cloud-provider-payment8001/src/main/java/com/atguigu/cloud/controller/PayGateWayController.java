package com.atguigu.cloud.controller;


import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.common.ResultData;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayGateWayController {

    @Resource
    private PayService payService;


    @GetMapping("/pay/gateway/get/{id}")
    public ResultData<Pay> getPayById(@PathVariable("id") Integer id) {
        Pay pay = payService.getPayById(id);
        return ResultData.success(pay);
    }


    @GetMapping("/pay/gateway/info")
    public ResultData<String> getGateWayInfo(){
        return ResultData.success("gateway info test："+ IdUtil.simpleUUID());
    }

}
