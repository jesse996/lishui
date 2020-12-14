package com.example.lishui.controller;

import com.example.lishui.dao.entity.ReformNumber;
import com.example.lishui.service.ReformNumberService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jesse on 2020/12/14 下午3:17
 */
@RestController
@RequestMapping("/api/reformNumber")
@Api(tags = "改革指数接口")
public class ReformNumberController {
    @Autowired
    ReformNumberService reformNumberService;

    @GetMapping
    @Operation(summary = "获取改革指数")
    ReformNumber get() {
        return reformNumberService.getReformNumber();
    }

    @PostMapping
    @Operation(summary = "修改改革指数")
    public ReformNumber update(@RequestBody ReformNumber reformNumber) {
        return reformNumberService.updateReformNumber(reformNumber);
    }
}
