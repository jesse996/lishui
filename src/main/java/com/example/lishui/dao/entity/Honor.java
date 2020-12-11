package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jesse on 2020/12/10 下午3:43
 *     荣誉展示表 (honor):
 *         id,name,create_at,img,content,status(0不可见，1可见)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Honor {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer status;

}
