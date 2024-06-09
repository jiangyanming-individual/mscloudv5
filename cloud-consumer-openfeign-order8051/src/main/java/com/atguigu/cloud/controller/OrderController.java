package com.atguigu.cloud.controller;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.api.OpenFeignApi;
import com.atguigu.cloud.common.ResultData;
import com.atguigu.cloud.constant.ReturnCodeEnum;
import com.atguigu.cloud.entities.PayDTO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    //注入接口
    @Resource
    private OpenFeignApi openFeignApi;


    /**
     * 添加模块
     * @param payDTO
     * @return
     */
    @GetMapping("/openfeign/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return openFeignApi.addPay(payDTO);
    }

    /**
     * 查询操作
     * @param id
     * @return
     */
    @GetMapping("/openfeign/pay/get/{id}")
    public ResultData getOrderById(@PathVariable("id") Integer id) {

        System.out.println("根据id查看支付订单流水信息");

        ResultData resultData= null;
        try {
            System.out.println("调用开始。。。" + DateUtil.now());
            resultData=openFeignApi.getPayInfo(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("调用结束。。。" + DateUtil.now());
            //返回错误信息：
            ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return resultData;
    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping("/openfeign/pay/getAll")
    public ResultData getOrderAll() {
        return openFeignApi.getPayAll();
    }


    /**
     * 获取consul中服务的信息：
     * @return
     */
    @GetMapping("/openfeign/pay/get/info")
    public String getConsulInfo() {
        return openFeignApi.getConsulInfo();
    }

}
