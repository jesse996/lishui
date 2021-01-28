package com.example.lishui.dto;

import com.example.lishui.dao.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: jesse
 * @Date: 2021/1/8 3:45 下午
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentWithCount implements Serializable {
    private Long id;
    private String name;
    private Integer number;
    private Integer weight;

    public DepartmentWithCount(Department department,Integer number) {
        this.id=department.getId();
        this.name = department.getName();
        this.weight = department.getWeight();
        this.number = number;
    }
}
