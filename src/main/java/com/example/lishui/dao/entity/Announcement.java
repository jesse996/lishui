package com.example.lishui.dao.entity;

import com.example.lishui.dao.AnnouncementRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by jesse on 2020/12/10 下午3:42
 * id,name(公告名),content(正文),username(发布人),create_at(发布时间),status(状态，0为隐藏，1为显示),weight(排序)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@ApiModel("公告实体")
public class Announcement implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "公告名字", required = true)
    @Column(nullable = false)
    private String name;

    @ApiModelProperty(value = "公告内容", required = true)
    @Column(nullable = false)
    private String content;

    @ApiModelProperty(value = "发布公告的人", required = true)
    @Column(nullable = false)
    private String username;

    @ApiModelProperty(value = "前端不用传创建时间，后端自动生成")
    @CreationTimestamp
    @Column(nullable = false)
    private Date createAt;

    //0不可见，1可见
    @ApiModelProperty(value = "1可见，0不可见", example = "1")
    @Column(nullable = false)
    private Integer status = 1;

    @Column(nullable = false)
    private Integer weight = 0;

}
