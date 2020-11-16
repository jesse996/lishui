package com.example.lishui.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by jesse on 2020/11/16 下午4:41
 * id,title,content,author,uid(添加此文章的管理员),create_at,update_at
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private String content;

    private String author;

    //    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional = false)
//    @JoinColumn(name = "uid")
//    User user;
    @Column(nullable = false)
    Long uid;

    /**
     * 可见范围，0为默认，代表不可见，1代表可见
     */
    private Integer status = 0;

    @CreationTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @UpdateTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;


}
