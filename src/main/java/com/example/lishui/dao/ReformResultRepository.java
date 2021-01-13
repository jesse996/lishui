package com.example.lishui.dao;

import com.example.lishui.dao.entity.ReformResult;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by jesse on 2020/12/29 下午8:09
 */
@Api(tags = "改革成果接口")
public interface ReformResultRepository extends JpaRepository<ReformResult,Long> {
    @Override
    @Query(value = "select u from #{#entityName} u order by u.weight asc")
    Page<ReformResult> findAll(Pageable pageable);
}
