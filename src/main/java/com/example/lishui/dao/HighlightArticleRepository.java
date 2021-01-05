package com.example.lishui.dao;

import com.example.lishui.dao.entity.HighlightArticle;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: jesse
 * @Date: 2021/1/5 3:18 下午
 */
@Api(tags = "闪光时刻文章接口")
public interface HighlightArticleRepository extends JpaRepository<HighlightArticle,Long> {
    @Operation(summary = "根据标题或发布人查找文章")
    @RestResource(path = "findAllByTitleOrAuthor")
    @Query(value = "select  u from #{#entityName} u where u.title like %:search% or u.username like %:search%")
    List<HighlightArticle> findAllByTitleOrUsername(@Param("search") String search, Pageable p);

    @Operation(summary = "根据时间范围查找文章")
    @ApiImplicitParams({@ApiImplicitParam(name = "start", value = "开始时间，形如：2020-01-01", example = "2020-01-01"),
            @ApiImplicitParam(name = "end", value = "结束时间，形如：2020-01-01", example = "2020-01-01")})
    @RestResource(path = "findAllByCreateAtBetween")
    List<HighlightArticle> findAllByCreateAtBetween(@DateTimeFormat(pattern = "yyyy-MM-dd") @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") Date start,
                                                          @DateTimeFormat(pattern = "yyyy-MM-dd") @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") Date end, Pageable p);

    @Operation(summary = "根据上一级名字查找文章")
    @RestResource(path = "findAllByTagName")
    List<HighlightArticle> findAllByTagEquals(String tag, Pageable p);
}
