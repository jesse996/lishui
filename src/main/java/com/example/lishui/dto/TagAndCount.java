package com.example.lishui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: jesse
 * @Date: 2021/1/7 1:37 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagAndCount implements Serializable {
    private Long id;
    private String name;
    private Integer number;
}
