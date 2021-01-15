package com.example.lishui.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: jesse
 * @Date: 2021/1/11 10:17 上午
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("通用二级模块实体")
public class Common {
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "二级模块名称",required = true)
    @Column(nullable = false)
    private String name;

    @ApiModelProperty(value = "一级模块名称", required = true)
//    @Column(nullable = false)
    private String module;

    @ApiModelProperty("封面图url")
//    @Column(nullable = false)
    private String img;

    @ApiModelProperty("0隐藏，1显示")
    @Column(nullable = false)
    private Integer status = 1;

    @Column(nullable = false,columnDefinition = "int not null default 0")
    @ApiModelProperty(value = "排序")
    private Integer weight;

    @ApiModelProperty(value = "2级模块样式", allowableValues = "range[1,2]",required = true)
    @Column(nullable = false)
    private Integer style = 0;

//    @ApiModelProperty(value = "大屏模块样式")
//    @Column(nullable = false,columnDefinition = "int default 0")
//    private Integer firstStyle = 0;
}
