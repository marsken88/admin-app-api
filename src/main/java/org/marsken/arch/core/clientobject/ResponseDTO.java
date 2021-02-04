package org.marsken.arch.core.clientobject;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/9/14 9:55 下午
 * @description：请求返回体
 * @modified By：
 * @version: 1.0.0$
 */

import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel("通用响应对象")
public class ResponseDTO<T> {


    private static final Integer successCode = 0;
    private T data;

    private Integer code;

    private Object msg;

    private ResponseDTO() {
        this.code = successCode;
        this.msg =  "success";
    }

    private ResponseDTO success(T data) {
        this.data = data;
        return this;
    }

    private ResponseDTO fail(Integer code, Object msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public static ResponseDTO builderSuccess(Object o) {
        return new ResponseDTO().success(o);
    }

    public static ResponseDTO builderFail(Integer code, Object msg) {
        return new ResponseDTO().fail(code, msg);
    }

}
