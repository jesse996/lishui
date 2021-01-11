package com.example.lishui.controller;

import com.example.lishui.dao.DepartmentRepository;
import com.example.lishui.dao.MemberRepository;
import com.example.lishui.dto.DepartmentWithCount;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("")
    public List<DepartmentWithCount> findAllDepartment() {
        return departmentRepository.findAll().stream()
                .map(x -> new DepartmentWithCount(x,memberRepository.countByDepartment(x.getName())))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DepartmentWithCount findById(@PathVariable("id") Long id) {
        var optional = departmentRepository.findById(id);
        if (optional.isPresent()) {
            var department = optional.get();
            return new DepartmentWithCount(department, memberRepository.countByDepartment(department.getName()));
        }else {
            return null;
        }
    }
}
