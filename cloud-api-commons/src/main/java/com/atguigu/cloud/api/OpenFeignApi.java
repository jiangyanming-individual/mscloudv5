package com.atguigu.cloud.api;


import com.atguigu.cloud.common.ResultData;
import com.atguigu.cloud.entities.PayDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * OpenFeign 定义的消费者cloud-payment-service中的服务接口
 */
@FeignClient(value = "cloud-payment-service") //服务的名称
public interface OpenFeignApi {

    /**
     * 添加支付接口
     * @param payDTO
     * @return
     */

    @PostMapping("/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);


    /**
     * 查询接口
     * @param id
     * @return
     */
    @GetMapping("/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id);



    @GetMapping("/pay/getAll")
    public ResultData getPayAll();


    @DeleteMapping("/pay/del/{id}")
    public ResultData delPay(@PathVariable("id") Integer id);


    @PutMapping("/pay/update")
    public ResultData updatePay(@RequestBody PayDTO payDTO);

    /**
     * 查询consul 存储服务信息
     * @return
     */
    @GetMapping("/pay/get/info")
    public String getConsulInfo();
}
