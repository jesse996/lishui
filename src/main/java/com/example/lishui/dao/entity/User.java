package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by jesse on 2020/11/15 下午4:42
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    private String tel;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private Timestamp createAt;
    @Column(nullable = false)
    private Timestamp updateAt;

}
