package com.example.lishui.dao;

import com.example.lishui.dao.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/10 下午4:04
 */
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query(value = "select max(weight) from department",nativeQuery = true)
    Optional<Integer> findMaxWeight();

}
