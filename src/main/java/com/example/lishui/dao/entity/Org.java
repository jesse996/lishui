package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jesse on 2020/12/10 下午3:39
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Org implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private String innerOrg;
}
