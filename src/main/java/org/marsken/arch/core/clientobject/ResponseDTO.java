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
public class ResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = -4505655308965878999L;

    //请求成功返回码为：0
    private static final Integer successCode = 0;
    //返回数据
    @ApiModelProperty(value = "返回的业务对象")
    private T data;
    //返回码
    @ApiModelProperty(value = "错误代码，0--成功，其他失败", example = "0")
    private Integer code;
    //返回描述
    @ApiModelProperty(value = "返回信息描述", example = "success")
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
