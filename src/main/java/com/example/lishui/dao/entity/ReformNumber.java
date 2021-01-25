package com.example.lishui.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jesse on 2020/12/10 下午3:43
 *     改革指数表 (reform):
 *         id,link
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable // 缓存
@ApiModel("改革指数实体")
public class ReformNumber implements Serializable {
    @Id
    @JsonIgnore
    private Long id;

    @ApiModelProperty("网址")
    private String link;
}
