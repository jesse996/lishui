package com.example.lishui.controller;

import com.example.lishui.dao.MyModuleRepository;
import com.example.lishui.dao.entity.MyModule;
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
 * Created by jesse on 2021/1/4 下午12:46
 */
@RequestMapping("/api/myModules")
@RestController
@Api(tags = "大屏模块接口")
public class MyModuleController {
    @Resource
    MyModuleRepository myModuleRepository;

    @Transactional
    @Operation(summary = "批量更新")
    @PostMapping("batchUpdate")
    public ResponseEntity<?> batchUpdate(@RequestBody List<MyModule> lists) throws Exception {
        return ResponseEntity.ok(myModuleRepository.saveAll(lists).stream().sorted(Comparator.comparingInt(MyModule::getWeight)).collect(Collectors.toList()));
    }
}
