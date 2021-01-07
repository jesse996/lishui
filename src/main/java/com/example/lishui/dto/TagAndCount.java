package com.example.lishui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: jesse
 * @Date: 2021/1/7 1:37 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagAndCount {
    private Long id;
    private String name;
    private Integer number;
}
