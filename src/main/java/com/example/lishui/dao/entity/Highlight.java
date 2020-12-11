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
 * 闪光时刻表 (highlight):
 * id,name,img,content,status
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Highlight implements Serializable {
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
