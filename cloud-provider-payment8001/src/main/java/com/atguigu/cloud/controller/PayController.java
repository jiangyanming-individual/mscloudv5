package com.atguigu.cloud.controller;


import com.atguigu.cloud.common.ResultData;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD") //swagger3
public class PayController {

    @Resource
    private PayService payService;
    /**
     * 增加
     * @param pay
     * @return
     */
    @PostMapping("/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int i = payService.addPay(pay);
        return ResultData.success("成功插入记录" + i);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法,id作为参数")
    public ResultData<Integer>  deletePay(@PathVariable("id") Integer id){
        int i = payService.deletePay(id);
        return ResultData.success(i);
    }

    /**
     * 更新操作
     * @param payDTO
     * @return
     */
    @PutMapping("/pay/update") //更新资源
    @Operation(summary = "更新",description = "更新支付流水方法,PayDTO作为参数")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int i = payService.updatePay(pay);
        return ResultData.success("成功修改记录" + i);
    }

    /**
     * 根据id查
     * @param id
     * @return
     */
    @GetMapping("/pay/get/{id}")
    @Operation(summary = "根据id查询",description = "查询支付流水方法,id作为参数")
    public ResultData<Pay> getPayById(@PathVariable("id") Integer id){ //修改成变量一致的；
        Pay pay = payService.getPayById(id);
        return ResultData.success(pay);
    }

    /**
     * 得到所有
     * @return
     */
    @GetMapping("/pay/getAll")
    @Operation(summary = "查询全部",description = "查询全部支付流水方法")
    public ResultData<List<Pay>> getPayById(){ //修改成变量一致的；
        List<Pay> payList = payService.getAll();
        return ResultData.success(payList);
    }

}
