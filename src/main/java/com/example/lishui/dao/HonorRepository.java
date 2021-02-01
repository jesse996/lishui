package com.example.lishui.dao;

import com.example.lishui.dao.entity.Honor;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by jesse on 2020/12/14 下午12:59
 */
@Api(tags = "荣誉展示接口")
public interface HonorRepository extends JpaRepository<Honor,Long> {
    @Operation(summary = "根据标题或发布人查找文章")
    @RestResource(path = "findAllByTitleOrAuthor")
    @Query(value = "select  u from #{#entityName} u where u.name like %:search% or u.username like %:search%")
    Page<Honor> findAllByNameOrUsername(@Param("search") String search, Pageable p);

    @Operation(summary = "根据时间范围查找文章")
    @ApiImplicitParams({@ApiImplicitParam(name = "start", value = "开始时间，形如：2020-01-01", example = "2020-01-01"),
            @ApiImplicitParam(name = "end", value = "结束时间，形如：2020-01-01", example = "2020-01-01")})
    @RestResource(path = "findAllByCreateAtBetween")
    Page<Honor> findAllByTimeBetween(@DateTimeFormat(pattern = "yyyy-MM-dd") @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") Date start,
                                                          @DateTimeFormat(pattern = "yyyy-MM-dd") @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") Date end, Pageable p);

}
