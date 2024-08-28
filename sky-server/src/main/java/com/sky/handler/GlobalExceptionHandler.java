package com.sky.handler;

import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex) {
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * 处理SQL异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        //Duplicate entry '111222333444555666' for key 'employee.idx_username'  //SQLIntegrityConstraintViolationException的异常消息
        String message = ex.getMessage();
        if (message.contains("Duplicate entry")) {    //只要异常消息包含了"Duplicate entry"就认为是重复
            String[] split = message.split(" ");    //上述异常消息，以空格为分隔符
            String username = split[2]; //得到重复的名字
            String msg = username + MessageConstant.ALREADY_EXISTS; //使用提前设置好的异常消息常量
            return Result.error(msg);
        }else {
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }

    }

}
