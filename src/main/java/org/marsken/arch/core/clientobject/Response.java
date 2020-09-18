package org.marsken.arch.core.clientobject;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/9/14 9:55 下午
 * @description：请求返回体
 * @modified By：
 * @version: 1.0.0$
 */

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel("通用响应对象")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -4505655308965878999L;

    //请求成功返回码为：0
    private static final String successCode = "0";
    //返回数据
    @ApiModelProperty(value = "返回的业务对象")
    private T data;
    //返回码
    @ApiModelProperty(value = "错误代码，0--成功，其他失败", example = "0")
    private String code;
    //返回描述
    @ApiModelProperty(value = "返回信息描述", example = "success")
    private Object msg;

    private Response() {
        this.code = successCode;
        this.msg =  "success";
    }

    private Response success(T data) {
        this.data = data;
        return this;
    }

    private Response fail(String code, Object msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public static Response builderSuccess(Object o) {
        return new Response().success(o);
    }

    public static Response builderFail(String code, Object msg) {
        return new Response().fail(code, msg);
    }

}
