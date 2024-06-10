package com.atguigu.cloud.controller;


import com.atguigu.cloud.api.OpenFeignApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class OrderCircuitController {


    @Resource
    private OpenFeignApi openFeignApi;

    /**
     * 开启服务熔断和降级
     * @param id
     * @return
     */
    @GetMapping(value = "/feign/pay/circuit/{id}")
    @CircuitBreaker(name = "cloud-payment-service",fallbackMethod = "myCircuitFallback") // 服务名，容错方法名
    public String myCircuitBreaker(@PathVariable("id") Integer id){
        return openFeignApi.myCircuit(id);
    }

    /**
     * 这里是容错的机制,一种兜底的方法
     * @param id
     * @param t
     * @return
     */
    public String myCircuitFallback(Integer id,Throwable t){
        return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }


    /**
     * 实现隔壁机制：基于信号量实现
     * @param id
     * @return
     */
//    @GetMapping(value = "/feign/pay/bulkhead/{id}")
//    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadFallback", type = Bulkhead.Type.SEMAPHORE)//隔壁类型
//    public String myBulkhead(@PathVariable("id") Integer id){
//        return openFeignApi.myBulkhead(id);
//    }
//
//    /**
//     * 这里是容错的机制,一种兜底的方法
//     * @param id
//     * @param t
//     * @return
//     */
//    public String myBulkheadFallback(Integer id,Throwable t){
//        return "myBulkheadFallback，隔板超出最大数量限制，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
//    }


    /**
     * 基于线程池实现：
     * @param id
     * @return
     */
    @GetMapping(value = "/feign/pay/bulkhead/{id}")
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadThreadPollFallback", type = Bulkhead.Type.THREADPOOL)//隔壁类型
    public CompletableFuture<String> myBulkheadThreadPool(@PathVariable("id") Integer id){
        System.out.println(Thread.currentThread().getName()+"\t"+"enter the method!!!");
        try {
            //模拟业务处理
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"exist the method!!!");
        //返回
        return CompletableFuture.supplyAsync(()-> {
            return openFeignApi.myBulkhead(id) +"\t" + "Bulkhead.Type.THREADPOOL";
        });
    }

    /**
     * 这里是容错的机制,一种兜底的方法
     * @param id
     * @param t
     * @return
     */
    public CompletableFuture<String> myBulkheadThreadPollFallback(Integer id,Throwable t){
        return CompletableFuture.supplyAsync(()->{
            return "myBulkheadThreadPollFallback，隔板超出最大数量限制，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
        });
    }

    /**
     * 限流操作
     * @param id
     * @return
     */
    @GetMapping(value = "/feign/pay/ratelimiter/{id}")
    @RateLimiter(name = "cloud-payment-service",fallbackMethod = "myRateLimiterFallback")//隔壁类型
    public String myBulkhead(@PathVariable("id") Integer id){
        return openFeignApi.myRatelimit(id);
    }

    /**
     * 这里是容错的机制,一种兜底的方法
     * @param id
     * @param t
     * @return
     */
    public String myRateLimiterFallback(Integer id,Throwable t){
        return "myRateLimiterFallback，你已经被限流了-----/(ㄒoㄒ)/~~";
    }


}
