package com.example.lishui;

import com.example.lishui.dao.entity.User;
import com.example.lishui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@SpringBootApplication
public class LishuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LishuiApplication.class, args);
    }

}

//初始化admin
@Component
class myRunner implements ApplicationRunner {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<User> user = userService.findUserByUsername("admin");
        if (user.isEmpty()) {
            User admin = new User(null, "admin", passwordEncoder.encode("123456"), "110", "ROLE_admin", null, null, null);
            userService.addUser(admin);
        }
    }
}