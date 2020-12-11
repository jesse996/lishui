package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by jesse on 2020/11/16 下午7:05
 * 操作记录
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

//    @Column(nullable = false)
//    Long uid;
//
//    @ManyToOne()
//    @JoinColumn(name = "uid")
//    private User user;

    @Column(nullable = false)
    String username;

    //get,post,delete,put,patch 5种类型
    @Column(nullable = false)
    String type;

    //具体操作名字
    @Column(nullable = false)
    String name;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp createAt;

}
