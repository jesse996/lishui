package com.example.lishui.controller;

import com.example.lishui.dao.ReformNewsTagRepository;
import com.example.lishui.dao.entity.ReformNewsTag;
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
 * @Date: 2021/1/13 6:08 下午
 */
@RequestMapping("/api/reformNewsTags")
@RestController
@Api(tags = "改革动态分类接口")
public class ReformNewsTagController {
    @Resource
    ReformNewsTagRepository repository;

    @Transactional
    @Operation(summary = "批量更新")
    @PostMapping("batchUpdate")
    public ResponseEntity<?> batchUpdate(@RequestBody List<ReformNewsTag> lists) throws Exception {
        return ResponseEntity.ok(repository.saveAll(lists).stream().sorted(Comparator.comparingInt(ReformNewsTag::getWeight)).collect(Collectors.toList()));
    }
}
