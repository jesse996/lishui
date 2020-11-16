package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jesse on 2020/11/16 下午7:05
 * id,uid,option,datetime
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Option {
    @Id
    @GeneratedValue
    private Long id;

    Long uid;

    String option;

    @Temporal(TemporalType.TIMESTAMP)
    Date optionTime;
}
