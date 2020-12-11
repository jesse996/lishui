package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jesse on 2020/12/10 下午3:43
 * 领导关怀表 (leader):
 * id,title,cover_img(封面图片),type(文章类型。0：图文，1：链接，2：视频),content,status(0不可见，1可见)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leader implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String coverImg;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer status = 1;
}
