package com.example.lishui.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jesse on 2020/12/10 下午3:42
 * id,rule(0代表不显示公告，1代表显示1个月公告，2代表显示2个月公告)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("公告规则实体")
public class AnnouncementRule implements Serializable {
    @Id
    @JsonIgnore
    private Long id = 1L;

    @Column(nullable = false)
    @ApiModelProperty(value = "0代表不显示公告，1代表显示1个月公告，2代表显示2个月公告",required = true)
    private Integer rule;
}
