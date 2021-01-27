package com.example.lishui.dao;

import com.example.lishui.dao.entity.ReformNewsTag;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @Author: jesse
 * @Date: 2021/1/7 2:14 下午
 */
@Api(tags = "改革动态分类接口")
public interface ReformNewsTagRepository extends JpaRepository<ReformNewsTag,Long> {
    @Operation(summary = "获取分类对应的文章数量")
    @RestResource(exported = false)
    Integer countByName(String tag);
}
