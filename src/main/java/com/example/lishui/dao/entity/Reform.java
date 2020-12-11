package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Reform implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String link;
}
