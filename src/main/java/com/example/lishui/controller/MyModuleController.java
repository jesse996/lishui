package com.example.lishui.controller;

import com.example.lishui.dao.MyModuleRepository;
import com.example.lishui.dao.entity.MyModule;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by jesse on 2021/1/4 下午12:46
 */
@RequestMapping("/api/myModules")
@RestController
@Api(tags = "大屏模块接口")
public class MyModuleController {
    @Resource
    MyModuleRepository myModuleRepository;

    @Operation(summary = "批量更新")
    @PostMapping("batchUpdate")
    public ResponseEntity<?> batchUpdate(@RequestBody List<MyModule> modules)throws Exception {
        Iterable<MyModule> it = myModuleRepository.saveAll(modules);
        List<MyModule> list = new ArrayList<>();
        Iterator<MyModule> itr = it.iterator();
        while(itr.hasNext()) {
            list.add(itr.next());
        }
        return ResponseEntity.ok(new ArrayList<>(list) );
    }
}
