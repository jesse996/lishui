package com.example.lishui.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jesse on 2020/12/10 下午3:43
 * 荣誉展示表 (honor):
 * id,name,create_at,img,content,status(0不可见，1可见)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable // 缓存
@org.hibernate.annotations.Cache(region = "honor", usage = CacheConcurrencyStrategy.READ_WRITE ) // 缓存名字以及策略
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

    @Column()
    @ApiModelProperty(value = "发布人",required = true)
    private String username;

    @Column(nullable = false)
    @ApiModelProperty(value = "0隐藏，1展示")
    private Integer status = 1;

    @Column(nullable = false,columnDefinition = "tinyint(1) default 1")
    @ApiModelProperty(value = "ture就是横版，false是竖版")
    private Boolean isHorizontal = true;

    @Column(nullable = false,columnDefinition = "int not null default 0")
    @ApiModelProperty(value = "排序")
    private Integer weight;

    @ApiModelProperty(value = "创建时间")
    @CreationTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}
