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
 * Created by jesse on 2020/12/29 下午8:07
 * 改革成果
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("改革成果实体")
public class ReformResult implements Serializable {
//    @Id
//    @GeneratedValue
//    @ApiModelProperty("id")
//    private Long id;
//
//    @Column(nullable = false)
//    @ApiModelProperty(value = "标题",required = true)
//    private String title;
//
//    @Column(nullable = false)
//    @ApiModelProperty(value = "封面图",required = true)
//    private String coverImg;
//
//    @Column(nullable = false)
//    @ApiModelProperty(value = "文章类型：图片，链接，视频",required = true)
//    private Integer type;
//
//    @Lob
//    @Basic(fetch = FetchType.LAZY)
//    @Column(nullable = false)
//    @ApiModelProperty(value = "文章内容",required = true)
//    private String content;
//
//    @Column()
//    @ApiModelProperty(value = "发布人",required = true)
//    private String username;
//
//    @Column(nullable = false)
//    @ApiModelProperty(value = "0隐藏，1展示")
//    private Integer status = 1;
//
//    @ApiModelProperty(value = "创建时间")
//    @CreationTimestamp
//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createAt;
//
//    @ApiModelProperty(value = "更新时间")
//    @UpdateTimestamp
//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updateAt;
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "模块名称",required = true)
    @Column(nullable = false)
    private String name;

    @ApiModelProperty("图标")
    @Column(nullable = false)
    private String icon;

    @ApiModelProperty("图标id")
    @Column(nullable = false)
    private Integer iconId;

    @ApiModelProperty("0隐藏，1显示")
    @Column(nullable = false)
    private Integer status = 1;

    @ApiModelProperty(value = "2级模块样式", allowableValues = "range[1,2]",required = true)
    @Column(nullable = false)
    private Integer style = 1;
}
