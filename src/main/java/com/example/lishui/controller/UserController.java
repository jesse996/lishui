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
    public CommonResult<User> addUser(@RequestBody User user) throws Exception {
        user = userService.addUser(user);
       return CommonResult.success(user, "create user success!");

    }

    @GetMapping("/delete/{id}")
    public CommonResult<String> deleteUser(@PathVariable("id") Long id) throws Exception {
        userService.deleteUserById(id);
        return CommonResult.success("删除成功");
    }

    @PostMapping("/update")
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
