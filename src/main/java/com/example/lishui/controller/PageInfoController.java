package com.example.lishui.controller;

import com.example.lishui.common.api.CommonResult;
import com.example.lishui.dao.entity.PageInfo;
import com.example.lishui.service.PageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jesse on 2020/11/16 下午2:56
 */
@RestController
@RequestMapping("/page")
public class PageInfoController {
    @Autowired
    PageInfoService pageInfoService;

    @GetMapping("/list")
    public CommonResult<List<PageInfo>> list() {
        var pageList = pageInfoService.listAll();
        return CommonResult.success(pageList);
    }

    @PostMapping("/add")
    public CommonResult<PageInfo> addPage(@RequestBody PageInfo pageInfo) {
        pageInfo = pageInfoService.addPageInfo(pageInfo);
        return CommonResult.success(pageInfo);
    }

    @PostMapping("/update")
    public CommonResult<PageInfo> updatePage(@RequestBody PageInfo pageInfo) {
        pageInfo = pageInfoService.updatePageInfo(pageInfo);
        return CommonResult.success(pageInfo);
    }

    @GetMapping("/delete/{id}")
    public CommonResult<String> deletePage(@PathVariable("id") Long id) {
        pageInfoService.deletePageInfo(id);
        return CommonResult.success("删除成功");
    }
}
