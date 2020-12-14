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
@ApiModel("闪光时刻实体")
public class Highlight implements Serializable {
    @Id
    @GeneratedValue
    @ApiModelProperty("id")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(value = "标题名",required = true)
    private String name;

    @Column(nullable = false)
    @ApiModelProperty(value = "封面图",required = true)
    private String img;

    @Column(nullable = false)
    @ApiModelProperty("内容")
    private String content;

    @Column(nullable = false)
    @ApiModelProperty(value = "三级模块样式，1,2",required = true)
    private Integer style = 1;

    @Column(nullable = false)
    @ApiModelProperty("状态")
    private Integer status;
}
