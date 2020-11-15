package com.example.lishui.service;

import com.example.lishui.dao.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by jesse on 2020/11/15 下午4:37
 */
public interface UserService {
    boolean addUser(User user);

    boolean deleteUserById(Long id);

    Optional<User> findUserById(Long id);

    List<User> findAllUser();

    User updateUser(User user);

}
