package com.example.lishui.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: jesse
 * @Date: 2021/1/7 2:09 下午
 * 改革动态分类实体
 */
@Entity
@Data
@AllArgsConstructor
@Cacheable // 缓存
@NoArgsConstructor
@ApiModel("改革动态分类实体")
public class ReformNewsTag {
    @Id
    @GeneratedValue
    @ApiModelProperty("分类ID")
    private Long id;

    @Column(nullable = false, unique = true)
    @ApiModelProperty(value = "分类名字", required = true)
    private String name;

    @Column(nullable = false,columnDefinition = "int not null default 0")
    @ApiModelProperty(value = "排序")
    private Integer weight;
}
