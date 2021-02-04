package org.marsken.arch.core.common;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 1:36 下午
 * @description：
 * @modified By：
 * @version: $
 */
public enum CodeMessage {
    FAIL(1, "fail"),
    EXCEPTION(500, "exception"),

    SUCC(0, "success");

    private Integer code;
    private String msg;

    private CodeMessage(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
