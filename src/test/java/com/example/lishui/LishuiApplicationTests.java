package com.example.lishui;

import com.example.lishui.dao.entity.User;
import com.example.lishui.service.UserService;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

@SpringBootTest
class LishuiApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void addUser() {
        User user = new User(null, "jeese", "pass", "186023", "admin",
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        Assert.isTrue(userService.addUser(user), "add user success");
        Assert.isTrue(!userService.addUser(user), "add user failed");
    }

    @Test
    void updateUser() {
        User user = new User(null, "jeese", "pass", "186023", "admin",
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        userService.addUser(user);
        Optional<User> old = userService.findUserById(1L);
        Assert.notNull(old.get(), "has id==1 user");

        User oldUser = old.get();
        String oldTel = oldUser.getTel();
        oldUser.setTel("new" + oldTel);
        User newUser = userService.updateUser(oldUser);
        Assert.isTrue(newUser.getTel().equals("new" + oldTel), "update success");
    }

    @Test
    void deleteUser(){
        User user = new User(null, "jeese", "pass", "186023", "admin",
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        userService.addUser(user);
        Optional<User> old = userService.findUserById(1L);
        Assert.notNull(old.get(), "has id==1 user");
        Assert.isTrue(userService.deleteUserById(1L),"delete success");
    }
}
