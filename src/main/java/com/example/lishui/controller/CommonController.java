package com.example.lishui.controller;

import com.example.lishui.dao.CommonRepository;
import com.example.lishui.dao.entity.Common;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: jesse
 * @Date: 2021/1/28 1:29 下午
 */
@RequestMapping("/api/commons")
@RestController
@Api(tags = "通用接口")
public class CommonController {
    @Resource
    CommonRepository repository;

    @Transactional
    @Operation(summary = "批量更新")
    @PostMapping("batchUpdate")
    public ResponseEntity<?> batchUpdate(@RequestBody List<Common> lists) throws Exception {
        return ResponseEntity.ok(repository.saveAll(lists).stream().sorted(Comparator.comparingInt(Common::getWeight)).collect(Collectors.toList()));
    }
}
