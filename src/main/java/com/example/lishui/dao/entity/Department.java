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
 * Created by jesse on 2020/12/10 下午3:42
 * id,name(部门名称),number(部门人数),sort(排序)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer number=0;

    @Column(nullable = false)
    private Integer sort=0;
}
