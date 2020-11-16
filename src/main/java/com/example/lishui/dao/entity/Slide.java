package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jesse on 2020/11/16 下午3:35
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slide {
    @Id
    @GeneratedValue
    Long id;

    String link;
}
