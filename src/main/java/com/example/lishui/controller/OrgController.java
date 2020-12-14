package com.example.lishui.controller;

import com.example.lishui.dao.entity.AnnouncementRule;
import com.example.lishui.dao.entity.Org;
import com.example.lishui.service.AnnouncementRuleService;
import com.example.lishui.service.OrgService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jesse on 2020/12/14 下午2:59
 */
@RestController()
@RequestMapping("/api/org")
@Api(tags = "机构简介接口")
public class OrgController {
    @Autowired
    OrgService orgService;

    @GetMapping
    @Operation(summary = "获取机构简介")
    public Org getOrg(){
        return orgService.getOrg();
    }

    @PostMapping
    @Operation(summary = "修改机构简介")
    public Org updateOrg(@RequestBody Org org){
        return orgService.updateOrg(org);
    }
}
