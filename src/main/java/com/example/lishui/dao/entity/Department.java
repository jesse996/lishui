package com.example.lishui.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jesse on 2020/12/10 下午3:42
 * id,name(部门名称),number(部门人数),weight(排序)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable // 缓存
@org.hibernate.annotations.Cache(region = "department", usage = CacheConcurrencyStrategy.READ_WRITE ) // 缓存名字以及策略
@ApiModel("部门实体")
@RepositoryRestResource(exported = true)
public class Department implements Serializable {
    @Id
    @GeneratedValue
    @ApiModelProperty("部门ID")
    private Long id;

    @Column(nullable = false,unique = true)
    @ApiModelProperty(value = "部门名字", required = true)
    private String name;

//    @Column(nullable = false)
//    @ApiModelProperty(value = "部门人数", required = true)
//    private Integer number = 0;

    @Column(nullable = false,columnDefinition = "int not null default 0")
    @ApiModelProperty(value = "排序")
    private Integer weight = 0;
}
