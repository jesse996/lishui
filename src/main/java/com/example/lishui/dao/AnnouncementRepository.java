package com.example.lishui.dao;

import com.example.lishui.dao.entity.Announcement;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/10 下午3:58
 */
@Api(tags = {"公告接口"})
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    @Query(value = "select max(weight) from announcement",nativeQuery = true)
    @Operation(summary = "找到最大的权重数，用来排序")
    Optional<Integer> findMaxWeight();
}
