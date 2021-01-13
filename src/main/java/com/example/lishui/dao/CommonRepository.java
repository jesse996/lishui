package com.example.lishui.dao;

import com.example.lishui.dao.entity.Common;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: jesse
 * @Date: 2021/1/11 10:23 上午
 */
@Api(tags = "通用接口")
public interface CommonRepository extends JpaRepository<Common,Long> {
    @Override
    @Query(value = "select u from #{#entityName} u order by u.weight asc")
    Page<Common> findAll(Pageable pageable);

    @Operation(summary = "根据一级模块名称查找所有二级")
    List<Common> findAllByModule(String module);
}
