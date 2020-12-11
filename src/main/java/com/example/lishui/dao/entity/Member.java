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
 *     机构成员表 (member) :
 *         id,name(姓名),job(职务),department(部门),img(照片),sort(排序)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private Integer sort;
}
