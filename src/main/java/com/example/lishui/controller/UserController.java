package com.example.lishui.controller;

import com.example.lishui.common.api.CommonResult;
import com.example.lishui.dao.entity.User;
import com.example.lishui.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jesse on 2020/11/15 下午5:45
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public CommonResult<User> addUser(@RequestBody User user) {
        boolean addSuccess = userService.addUser(user);
        if (addSuccess) {
            log.info("create user success");
            return CommonResult.success(user, "create user success!");
        } else {
            log.info("create user failed");
            return CommonResult.failed("create user failed!");
        }
    }

    @GetMapping("/delete/{id}")
    public CommonResult<String> deleteUser(@PathVariable("id") Long id) {
        boolean addSuccess = userService.deleteUserById(id);
        if (addSuccess) {
            log.info("delete user success");
            return CommonResult.success("delete user success");
        } else {
            log.info("delete user  failed");
            return CommonResult.failed("delete user failed!");
        }
    }

    @GetMapping("/update")
    public CommonResult<User> updateUser(@RequestBody User newUser) {
        userService.updateUser(newUser);
        return CommonResult.success(newUser);
    }

    @GetMapping("/list")
    public CommonResult<List<User>> allUser(){
        List<User> allUser = userService.findAllUser();
        return CommonResult.success(allUser);
    }
}
