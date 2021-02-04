package org.marsken.arch.core.advice;

import lombok.extern.slf4j.Slf4j;
import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.arch.core.common.CodeMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/9/15 12:41 上午
 * @description：统一处理类
 * @modified By：
 * @version: 1.0.0$
 */
@Slf4j
@ControllerAdvice
public class BizControllerAdvice {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<Void> uniteExceptionHandler(Exception e) {
        log.error("系统异常", e);
        return ResponseDTO.builderFail(CodeMessage.EXCEPTION.getCode(), e.getMessage());
    }

}
