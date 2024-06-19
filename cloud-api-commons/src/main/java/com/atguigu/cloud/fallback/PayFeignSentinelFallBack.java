package com.atguigu.cloud.fallback;

import com.atguigu.cloud.api.PayFeignSentinelApi;
import com.atguigu.cloud.common.ResultData;
import com.atguigu.cloud.constant.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * 出现异常,触发服务降级处理
 */
@Component
public class PayFeignSentinelFallBack implements PayFeignSentinelApi {
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
