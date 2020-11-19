package com.example.lishui.component;

import com.example.lishui.dao.UserRepository;
import com.example.lishui.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by jesse on 2020/11/19 上午10:46
 */
@Component
public class MyListener {
    @Autowired
    UserRepository userRepository;

    //用户登陆成功，修改最后登陆时间
    @EventListener(AuthenticationSuccessEvent.class)
    public void AuthenticationSuccessListener(AuthenticationSuccessEvent authenticationSuccessEvent) {
        UserDetailImpl userDetails = (UserDetailImpl) authenticationSuccessEvent.getAuthentication().getPrincipal();
        Long userId = userDetails.getId();
        var userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setLastLoginDateTime(Timestamp.from(Instant.now()));
        }
    }
}
