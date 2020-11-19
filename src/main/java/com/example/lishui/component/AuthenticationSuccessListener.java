package com.example.lishui.component;

import com.example.lishui.dao.UserRepository;
import com.example.lishui.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * Created by jesse on 2020/11/19 上午9:57
 */
@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    //用户认证成功事件
    @Autowired
    UserRepository userRepository;
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        //用户通过输入用户名和密码登录成功
//        System.out.println("---用户通过输入用户名和密码登录成功 ---");
        UserDetailImpl userDetails = (UserDetailImpl) authenticationSuccessEvent.getAuthentication().getPrincipal();
        Long userId = userDetails.getId();
//        System.out.println("userid= " + userId);
        User user = userRepository.findById(userId).get();
//        user.setLastLoginDateTime(LocalDateTime.now());
        user.setLastLoginDateTime(Timestamp.from(Instant.now()));
//        System.out.println("LocalDateTime 当前时间：" +LocalDateTime.now().toString());
//        System.out.println("Date 当前时间：" +new Date().toString());
//        System.out.println("Timestamp 当前时间：" +Timestamp.from(Instant.now()));
//        System.out.println(authenticationSuccessEvent.getAuthentication().getCredentials());

    }
}
