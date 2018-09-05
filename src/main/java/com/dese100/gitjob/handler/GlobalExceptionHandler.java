package com.dese100.gitjob.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dese100.gitjob.domain.result.Result;
import com.dese100.gitjob.exception.BizException;
import com.dese100.gitjob.exception.code.ExceptionCode;
/**
 * @author zuihou
 * @createTime 2017-12-13 17:04
 */
@ControllerAdvice(value = {
        "com.dese100.gitjob.controller",
        "com.dese100.gitjob.service",
})
@ResponseBody  //返回结果为json
public class GlobalExceptionHandler {
    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BizException.class)
    public Result baseExceptionHandler(BizException ex) {
        log.error("BizException:", ex);
        return Result.fail(ex);
    }

    @ExceptionHandler(Exception.class)
    public Result otherExceptionHandler(Exception ex) {
        log.error("Exception:", ex);
        return Result.fail(ex);
    }
}