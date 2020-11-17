package com.example.lishui.service.impl;

import com.example.lishui.dao.UserRepository;
import com.example.lishui.dao.entity.User;
import com.example.lishui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by jesse on 2020/11/15 下午5:20
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) throws Exception {
        Optional<User> u = userRepository.findByUsername(user.getUsername());
        System.out.println(u);
        if (u.isEmpty()) {
            return userRepository.save(user);
        } else {
            throw new Exception("用户名已存在");
        }
    }

    @Override
    public void deleteUserById(Long id) {
//        Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()) {
            userRepository.deleteById(id);
//        } else {
//            throw new Exception("删除ID不存在");
//        }
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }

//    @Override
//    public String login(String username, String password) {
//        Optional<User> user = userRepository.findByUsername(username);
//        if (user.isPresent()&&passwordEncoder.matches(password, user.get().getPassword())) {
//            return username;
//        }else {
//            throw new BadCredentialsException("用户名或密码不正确");
//        }
//    }
}
