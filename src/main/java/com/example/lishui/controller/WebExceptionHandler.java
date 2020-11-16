package com.example.lishui.controller;

import com.example.lishui.common.api.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jesse on 2020/11/16 下午1:59
 */
@ControllerAdvice
@RestController
@Slf4j
public class WebExceptionHandler {
//    @ExceptionHandler
//    public ResultBean unknownAccount(UnknownAccountException e) {
//        log.error("账号不存在", e);
//        return ResultBean.error(1, "账号不存在");
//    }
//
//    @ExceptionHandler
//    public ResultBean incorrectCredentials(IncorrectCredentialsException e) {
//        log.error("密码错误", e);
//        return ResultBean.error(-2, "密码错误");
//    }

    @ExceptionHandler
    public CommonResult<String> unknownException(Exception e) {
        log.error("发生了未知异常", e);
        return CommonResult.failed(e.getMessage());
    }

}
