package com.example.lishui.dao.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jesse on 2020/12/10 下午3:42
 *  id,rule(0代表不显示公告，1代表显示1个月公告，2代表显示2个月公告)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("公告规则实体")
public class AnnouncementRule implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer rule;
}
