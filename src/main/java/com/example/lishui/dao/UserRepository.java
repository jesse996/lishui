package com.example.lishui.dao;

import com.example.lishui.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jesse on 2020/11/15 下午4:57
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUsername(String username);
}
