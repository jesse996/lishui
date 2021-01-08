package com.example.lishui.dao;

import com.example.lishui.dao.entity.Member;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/11 下午7:56
 */
@Api(tags = "机构成员接口")
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "select max(weight) from member", nativeQuery = true)
    Optional<Integer> findMaxWeight();


    @Operation(summary = "根据名字查找")
    Page<Member> findAllByNameContains(String name, Pageable p);

    @Operation(summary = "根据部门名字查找")
    Page<Member> findAllByDepartment(String department, Pageable p);
}
