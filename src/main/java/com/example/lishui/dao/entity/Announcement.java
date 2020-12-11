package com.example.lishui.dao.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by jesse on 2020/12/10 下午3:42
 * id,name(公告名),content(正文),username(发布人),create_at(发布时间),status(状态，0为隐藏，1为显示),sort(排序)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("公告实体")
public class Announcement implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String username;

    @ApiModelProperty(value = "前端不用传创建时间，后端自动生成",name = "creatAt",required = false)
    @CreationTimestamp
    @Column(nullable = false)
    private Date createAt;

    //0不可见，1可见
    @Column(nullable = false)
    private Integer status = 1;

    @Column(nullable = false)
    private Integer sort = 0;
}
