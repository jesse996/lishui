package com.example.lishui.dao;

import com.example.lishui.dao.entity.OutstandingCase;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by jesse on 2020/12/29 下午8:10
 */
@Api(tags = "优秀案例接口")
public interface OutstandingCaseRepository extends JpaRepository<OutstandingCase,Long> {
    @Override
    @Query(value = "select u from #{#entityName} u order by u.weight asc")
    Page<OutstandingCase> findAll(Pageable pageable);
}
