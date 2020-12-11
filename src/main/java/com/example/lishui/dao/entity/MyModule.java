package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jesse on 2020/12/10 下午3:43
 *     大屏模块表 (module):
 *         id,name,img
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyModule implements Serializable {
    @Id
    @GeneratedValue
    private Long id;


    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String img;
}
