package com.example.lishui.dao;

import com.example.lishui.dao.entity.Announcement;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/10 下午3:58
 */
@Api(tags = {"公告接口"})
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    @Override
    @Query(value = "select u from #{#entityName} u order by u.weight asc")
    Page<Announcement> findAll(Pageable pageable);

    @Query(value = "select max(weight) from announcement",nativeQuery = true)
    @Operation(summary = "找到最大的权重数，用来排序")
    Optional<Integer> findMaxWeight();
}
