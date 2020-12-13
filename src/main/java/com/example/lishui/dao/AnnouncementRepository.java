package com.example.lishui.dao;

import com.example.lishui.dao.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/10 下午3:58
 */
//@Api(tags = "公告接口")
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
//    @Operation(summary = "根据id找到公告")
//    Optional<Announcement> findById(Long id);


//    @Override
//    @Query(value = "insert into announcement(content,create_at,name,sort,status,username) values (:#{#entity.content},:#{#entity.createAt},:#{#entity.name},select max(sort)+1 from announcement,:#{#entity.status},:#{#entity.username},)}",nativeQuery = true)
//    <S extends Announcement> S save(@Param("entity") S entity);
//
    @Query(value = "select max(weight) from announcement",nativeQuery = true)
    Optional<Integer> findMaxWeight();
}
