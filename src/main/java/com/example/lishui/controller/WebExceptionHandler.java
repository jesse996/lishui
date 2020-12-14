package com.example.lishui.controller;

import com.example.lishui.common.api.CommonResult;
import com.example.lishui.common.api.ResultCode;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.PropertyValueException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by jesse on 2020/11/16 下午1:59
 */
@RestControllerAdvice
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

//  data rest 查找不存在的id时候会出现这个异常
//    @ExceptionHandler
//    public void resourceNotFoundException(ResourceNotFoundException e) throws ResourceNotFoundException{
//        log.error("发生了资源未找到异常", e);
////        return CommonResult.failed("资源不存在！");
//        throw  e;
//    }

    @ExceptionHandler
    public CommonResult<String> handle404(NoHandlerFoundException e) {
        log.error("发生了404异常:{}", e.getMessage());
        return CommonResult.notFound();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult<String>  handlePropertyValueException(PropertyValueException e){
        log.error("发生了传参异常:{}", e.getMessage());
        return CommonResult.failed("传参异常："+e.getMessage());
    }


//
//    @ExceptionHandler
//    public CommonResult<String> unknownException(Exception e) {
//        log.error("发生了未知异常", e);
//        return CommonResult.failed(e.getMessage());
//    }



}
