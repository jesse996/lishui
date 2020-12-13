package com.example.lishui.controller;

import com.example.lishui.dao.entity.AnnouncementRule;
import com.example.lishui.service.AnnouncementRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/13 下午6:31
 */
@RestController
@RequestMapping("/api/announcementRule")
@Api(tags = "公告规则接口")
public class AnnouncementRuleController {
    @Autowired
    AnnouncementRuleService announcementRuleService;

    @GetMapping
    @Operation(summary = "获取公告规则")
    public AnnouncementRule getAnnouncementRule(){
        return announcementRuleService.getAnnouncementRule();
    }

    @PostMapping
    @Operation(summary = "修改公告规则")
    public AnnouncementRule updateAnnouncementRule(@RequestBody AnnouncementRule announcementRule){
        return announcementRuleService.updateAnnouncementRule(announcementRule);
    }
}
