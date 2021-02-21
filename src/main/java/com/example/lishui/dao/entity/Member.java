package com.example.lishui.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jesse on 2020/12/10 下午3:42
 * 机构成员表 (member) :
 * id,name(姓名),job(职务),department(部门),img(照片),weight(排序)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable // 缓存
@org.hibernate.annotations.Cache(region = "member", usage = CacheConcurrencyStrategy.READ_WRITE ) // 缓存名字以及策略
@ApiModel("机构成员实体")
public class Member implements Serializable {
    @Id
    @GeneratedValue
    @ApiModelProperty("id")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(value = "成员姓名", required = true)
    private String name;

    @Column(nullable = false)
    @ApiModelProperty(value = "成员职务", required = true)
    private String job;

    @Column(nullable = false,columnDefinition = "bigint not null default 0")
    @ApiModelProperty(value = "成员部门id", required = true)
    private Long departmentId;

    @Column(nullable = false)
    @ApiModelProperty(value = "成员照片", required = true)
    private String img;

    @Column(nullable = false,columnDefinition = "int not null default 0")
    @ApiModelProperty(value = "排序")
    private Integer weight = 0;

    @Column(nullable = false)
    @ApiModelProperty(value = "0隐藏，1展示")
    private Integer status = 1;
    @Column(nullable = false)
    @ApiModelProperty(value = "部门名字")
    private String department ;


}
