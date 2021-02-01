package com.example.lishui.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable // 缓存
@org.hibernate.annotations.Cache(region = "outstanding_case_article", usage = CacheConcurrencyStrategy.READ_WRITE ) // 缓存名字以及策略
@ApiModel("优秀案例文章实体")
public class OutstandingCaseArticle implements Serializable {
    @Id
    @GeneratedValue
    @ApiModelProperty("id")
    private Long id;

    @Column(nullable = false,columnDefinition = "bigint not null default 0")
    @ApiModelProperty(value = "分类id",required = true)
    private Long tagId = 0L;

    @Column(nullable = false)
    @ApiModelProperty(value = "标题",required = true)
    private String title;

    @Column(nullable = false)
    @ApiModelProperty(value = "封面图",required = true)
    private String coverImg;

    @Column(nullable = false)
    @ApiModelProperty(value = "文章类型：图片，链接，视频",required = true)
    private Integer type;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    @ApiModelProperty(value = "文章内容",required = true)
    private String content;

    @Column()
    @ApiModelProperty(value = "发布人",required = true)
    private String username;

    @Column(nullable = false)
    @ApiModelProperty(value = "0隐藏，1展示")
    private Integer status = 1;

    @ApiModelProperty(value = "创建时间")
    @CreationTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @ApiModelProperty(value = "更新时间")
    @UpdateTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @Column(nullable = false,columnDefinition = "int not null default 0")
    @ApiModelProperty(value = "排序")
    private Integer weight = 0;

    //用户自己选的日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "自己选的日期")
    private Date time;
}
