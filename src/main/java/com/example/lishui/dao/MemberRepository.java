package com.example.lishui.dao;

import com.example.lishui.dao.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/11 下午7:56
 */
public interface MemberRepository extends JpaRepository<Member,Long> {
}
