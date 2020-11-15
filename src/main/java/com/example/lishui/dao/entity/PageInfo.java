package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jesse on 2020/11/15 下午8:21
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    private String alias;
    private String link;
    private Integer orderValue;
}
