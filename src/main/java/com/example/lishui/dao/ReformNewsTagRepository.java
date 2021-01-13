package com.example.lishui.dao;

import com.example.lishui.dao.entity.ReformNewsTag;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: jesse
 * @Date: 2021/1/7 2:14 下午
 */
@Api(tags = "改革动态分类接口")
public interface ReformNewsTagRepository extends JpaRepository<ReformNewsTag,Long> {
}
