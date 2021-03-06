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
 * Created by jesse on 2020/12/29 下午8:07
 * 优秀案例
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable // 缓存
@org.hibernate.annotations.Cache(region = "outstanding_case", usage = CacheConcurrencyStrategy.READ_WRITE ) // 缓存名字以及策略
@ApiModel("优秀案例实体")
public class OutstandingCase implements Serializable {

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

    @Column(nullable = false,columnDefinition = "int not null default 0")
    @ApiModelProperty(value = "排序")
    private Integer weight = 0;


}
