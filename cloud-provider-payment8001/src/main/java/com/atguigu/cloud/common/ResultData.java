package com.atguigu.cloud.common;


import com.atguigu.cloud.constant.ReturnCodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 自定义统一返回类
 * @param <T>
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {

    private String code;
    private String message;
    private T data;
    private long timestamp; //时间戳

    public ResultData() {
        //获得当前系统时间
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 请求成功的返回封装类
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setData(data);
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        return resultData;
    }

    /**
     * 请求失败的返回封装类
     * @param code
     * @param message
     * @return
     * @param <T>
     */
    public static <T> ResultData<T> fail(String code, String message){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }

}
