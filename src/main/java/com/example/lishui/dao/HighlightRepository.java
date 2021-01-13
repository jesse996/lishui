package com.example.lishui.dao;

import com.example.lishui.dao.entity.Highlight;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by jesse on 2020/12/10 下午4:08
 */
@Api(tags = "闪光时刻接口")
public interface HighlightRepository extends JpaRepository<Highlight,Long> {
    @Override
    @Query(value = "select u from #{#entityName} u order by u.weight asc")
    Page<Highlight> findAll(Pageable pageable);
}
