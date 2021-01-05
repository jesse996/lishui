package com.example.lishui.dao;

import com.example.lishui.dao.entity.Department;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by jesse on 2020/12/10 下午4:04
 */
@Api(tags = "部门接口")
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query(value = "select max(weight) from department",nativeQuery = true)
    Optional<Integer> findMaxWeight();

    @Operation(summary = "根据名字查找")
    List<Department> findAllByNameContains(String name, Pageable p);

}
