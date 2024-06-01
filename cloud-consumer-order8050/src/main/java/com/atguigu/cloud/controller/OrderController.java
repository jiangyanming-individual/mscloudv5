package com.atguigu.cloud.controller;


import com.atguigu.cloud.common.ResultData;
import com.atguigu.cloud.entities.PayDTO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

//    private static final String PAY_SERVICE_URL="http://localhost:8001";
    /**
     * 使用Consul中注册的服务
     */
    private static final String PAY_SERVICE_URL="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     * @param payDTO
     * @return
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PAY_SERVICE_URL + "/pay/add",payDTO,ResultData.class);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getOrderById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAY_SERVICE_URL + "/pay/get/"+ id,ResultData.class,id);
    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping("/consumer/pay/getAll")
    public ResultData getOrderAll() {
        return restTemplate.getForObject(PAY_SERVICE_URL + "/pay/getAll",ResultData.class);
    }


    /**
     * 更新操作，底层是POST请求
     * @param payDTO
     * @return
     */
    @GetMapping("/consumer/pay/update")
    public ResultData updateOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PAY_SERVICE_URL + "/pay/update",payDTO,ResultData.class);
    }


    /**
     * 删除操作，返回void
     * @param id
     * @return
     */
    @GetMapping("/consumer/pay/del/{id}")
    public void delOrder(@PathVariable("id") Integer id) {
         restTemplate.delete(PAY_SERVICE_URL + "/pay/del/"+ id);
    }


}
