package com.example.lishui.dao;

import com.example.lishui.dao.entity.User;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by jesse on 2020/11/15 下午4:57
 */
@Repository
@Api(tags = "用户接口")
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
