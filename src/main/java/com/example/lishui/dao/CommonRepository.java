package com.example.lishui.dao;

import com.example.lishui.dao.entity.Common;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: jesse
 * @Date: 2021/1/11 10:23 上午
 */
@Api(tags = "通用接口")
public interface CommonRepository extends JpaRepository<Common,Long> {
    @Operation(summary = "根据一级模块名称查找所有二级")
    List<Common> findAllByModule(String module);
}
