package com.qs.exception;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {
        // 打印出错误日志
//        LOGGER.error(e.getMessage(), e);
        return "this is a global error "  + e.getMessage();
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String arrayOutOfRangeException(Exception e) {
//        LOGGER.error(e.getMessage(), e);
        return "数组越界 " + e.getMessage();
    }
}
