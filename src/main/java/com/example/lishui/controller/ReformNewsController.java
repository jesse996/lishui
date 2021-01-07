package com.example.lishui.controller;

import com.example.lishui.dao.ReformNewsRepository;
import com.example.lishui.dao.ReformNewsTagRepository;
import com.example.lishui.dao.entity.ReformNewsTag;
import com.example.lishui.dto.TagAndCount;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: jesse
 * @Date: 2021/1/7 1:41 下午
 */
@RestController
@RequestMapping("/api/reformNews")
@Api(tags = "改革动态接口")
public class ReformNewsController {
    @Autowired
    ReformNewsRepository newsRepository;
    @Autowired
    ReformNewsTagRepository tagRepository;

    @GetMapping("/search/tagsAndCount")
    @Operation(summary = "获取所有分类和分类对应的数量")
    List<TagAndCount> findAllTagsAndCount() {
        List<ReformNewsTag> all = tagRepository.findAll();
        return all.stream().map(x -> new TagAndCount(x.getId(), x.getName(), newsRepository.countByTag(x.getName()))).collect(Collectors.toList());
    }

//    @PostMapping("/tag")
//    @Operation(summary = "添加分类")
//    public ReformNewsTag addTag(ReformNewsTag tag) {
//        return tagRepository.save(tag);
//    }
//
//
//    @DeleteMapping("/tag/{id}")
//    @Operation(summary = "删除分类")
//    public void deleteTagById(@PathVariable("id") Long id) {
//        tagRepository.deleteById(id);
//    }
}
