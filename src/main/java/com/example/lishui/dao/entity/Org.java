package com.example.lishui.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jesse on 2020/12/10 下午3:39
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable // 缓存
@ApiModel("机构简介实体")
public class Org implements Serializable {
    @Id
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(value = "机构职能",required = true)
    private String description = "";

    @ApiModelProperty(value = "改革办内设机构图片链接")
    private String innerOrg;
}
