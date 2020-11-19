package com.example.lishui.component;

import com.example.lishui.dao.OptionRepository;
import com.example.lishui.dao.UserRepository;
import com.example.lishui.dao.entity.Option;
import com.example.lishui.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by jesse on 2020/11/19 上午10:46
 */
@Component
@Async
public class MyListener {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OptionRepository optionRepository;

    //用户登陆成功，修改最后登陆时间，并添加登陆记录
    @EventListener(AuthenticationSuccessEvent.class)
    public void AuthenticationSuccessListener(AuthenticationSuccessEvent authenticationSuccessEvent) {
        UserDetailImpl userDetails = (UserDetailImpl) authenticationSuccessEvent.getAuthentication().getPrincipal();
        Long userId = userDetails.getId();
        var userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            //修改最后登陆时间
            user.setLastLoginDateTime(Timestamp.from(Instant.now()));
            userRepository.save(user);
            //新增登陆记录
            optionRepository.save(new Option(null, user.getUsername(), "post", "登陆", null));
        }
    }
}
