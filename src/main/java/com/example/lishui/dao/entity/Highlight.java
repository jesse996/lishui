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
    private Long id;

    @ApiModelProperty(value = "模块名称",required = true)
    @Column(nullable = false)
    private String name;

    @ApiModelProperty("封面图url")
    @Column(nullable = false)
    private String img;

    @ApiModelProperty("0隐藏，1显示")
    @Column(nullable = false)
    private Integer status = 1;

    @ApiModelProperty(value = "2级模块样式", allowableValues = "range[1,2]",required = true)
    @Column(nullable = false)
    private Integer style = 1;

    @ApiModelProperty(value = "是否可以删除,1可以删，0不可以删")
    @Column(nullable = false,columnDefinition = "int DEFAULT 1")
    private Integer deletable = 1;
}
