package com.example.lishui.dao;

import com.example.lishui.dao.entity.ReformNews;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by jesse on 2020/12/14 下午2:05
 */
@Api(tags = "改革动态接口")
public interface ReformNewsRepository extends JpaRepository<ReformNews, Long> {
    @Operation(summary = "根据标题或发布人查找文章")
    @RestResource(path = "findAllByTitleOrAuthor")
    @Query(value = "select  u from #{#entityName} u where u.title like %:search% or u.username like %:search%")
    List<ReformNews> findAllByTitleOrUsername(@Param("search") String search);
//    List<ReformNews> findAllByTitleContainingOrUsernameContaining(@Param("search") String search);

    @Operation(summary = "根据时间范围查找文章")
    @ApiImplicitParams({@ApiImplicitParam(name = "start", value = "开始时间，形如：2020-01-01", example = "2020-01-01"),
            @ApiImplicitParam(name = "end", value = "结束时间，形如：2020-01-01", example = "2020-01-01")})
    @RestResource(path = "findAllByCreateAtBetween")
    List<ReformNews> findAllByCreateAtBetween(@DateTimeFormat(pattern = "yyyy-MM-dd") @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") Date start,
                                              @DateTimeFormat(pattern = "yyyy-MM-dd") @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") Date end);
}
