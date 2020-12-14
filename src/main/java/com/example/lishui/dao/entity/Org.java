package com.example.lishui.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jesse on 2020/12/10 下午3:39
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("机构简介实体")
public class Org implements Serializable {
    @Id
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(value = "机构职能",required = true)
    private String description = "";

    @ApiModelProperty(value = "改革办内设机构")
    private String innerOrg;
}
