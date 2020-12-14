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
 * Created by jesse on 2020/12/10 下午3:43
 * 荣誉展示表 (honor):
 * id,name,create_at,img,content,status(0不可见，1可见)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("荣誉证书实体")
public class Honor {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(value = "证书名称", required = true)
    private String name;

    @Column(nullable = false)
    @ApiModelProperty(value = "证书图片", required = true)
    private String img;

    @Column(nullable = false)
    @ApiModelProperty(value = "证书详情", required = true)
    private String content = "";

    @Column(nullable = false)
    @ApiModelProperty(value = "0隐藏，1展示")
    private Integer status = 1;

}
