package com.example.lishui.service;

import com.example.lishui.dao.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by jesse on 2020/11/15 下午4:37
 */
public interface UserService {
    User addUser(User user) throws Exception;

    void deleteUserById(Long id);

    Optional<User> findUserById(Long id);

    Optional<User> findUserByUsername(String username);

    List<User> findAllUser();

    User updateUser(User user);


    //返回token
//    String login(String username, String password);

}
