package com.atguigu.cloud.exception;



import com.atguigu.cloud.common.ResultData;
import com.atguigu.cloud.constant.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理类
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exceptionHandle(Exception e) {
        System.out.println("######### 系统内部异常#########");
        log.error("系统内部错误", e.getMessage(),e);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
    }

}
