package com.example.lishui.controller;

import com.example.lishui.dao.DepartmentRepository;
import com.example.lishui.dao.MemberRepository;
import com.example.lishui.dao.entity.Department;
import com.example.lishui.dto.DepartmentWithCount;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: jesse
 * @Date: 2021/1/8 3:06 下午
 */
@RequestMapping("/api/departments")
@RestController
@Api(tags = "部门接口")
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    MemberRepository memberRepository;


    //部门返回人数
    @Operation(summary = "查找所有")
    @GetMapping("/findAllWithWeight")
    public List<DepartmentWithCount> findAllDepartment() {
        return departmentRepository.findAll().stream()
                .map(x -> new DepartmentWithCount(x,memberRepository.countByDepartmentId(x.getId())))
                .sorted(Comparator.comparingInt(DepartmentWithCount::getWeight))
                .collect(Collectors.toList());
    }

    @Transactional
    @Operation(summary = "批量更新")
    @PostMapping("batchUpdate")
    public ResponseEntity<?> batchUpdate(@RequestBody List<Department> lists) throws Exception {
        return ResponseEntity.ok(departmentRepository.saveAll(lists).stream().sorted(Comparator.comparingInt(Department::getWeight)).collect(Collectors.toList()));
    }


}
