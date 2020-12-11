package com.example.lishui.dao;

import com.example.lishui.dao.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/10 下午4:04
 */
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
