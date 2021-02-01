package com.example.lishui.dao;

import com.example.lishui.dao.entity.CommonArticle;
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
 * @Author: jesse
 * @Date: 2021/1/11 10:23 上午
 */
@Api(tags = "通用文章接口")
public interface CommonArticleRepository extends JpaRepository<CommonArticle, Long> {
    @Operation(summary = "根据标题或发布人查找文章")
    @RestResource(path = "findAllByTitleOrAuthor")
    @Query(value = "select  u from #{#entityName} u where u.moduleId=:moduleId and u.tagId=:tagId and u.title like %:search% or u.username like %:search%")
    Page<CommonArticle> findAllByTitleOrUsername(@Param("module") Long moduleId,@Param("tag") Long tagId, @Param("search") String search, Pageable p);

    @Operation(summary = "根据时间范围查找文章")
    @ApiImplicitParams({@ApiImplicitParam(name = "start", value = "开始时间，形如：2020-01-01", example = "2020-01-01"),
            @ApiImplicitParam(name = "end", value = "结束时间，形如：2020-01-01", example = "2020-01-01")})
    @RestResource(path = "findAllByCreateAtBetween")
    Page<CommonArticle> findAllByModuleIdAndTagIdAndTimeBetween( Long moduleId,Long tagId,@DateTimeFormat(pattern = "yyyy-MM-dd") @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") Date start,
                                                          @DateTimeFormat(pattern = "yyyy-MM-dd") @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") Date end, Pageable p);

    @Operation(summary = "根据一级名称和二级名称查找文章")
    Page<CommonArticle> findAllByModuleIdAndTagId(Long moduleId, Long tagId,Pageable p);
}
