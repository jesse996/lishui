package com.example.lishui.dao;

import com.example.lishui.dao.entity.Leader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/10 下午4:15
 */
public interface LeaderRepository extends JpaRepository<Leader,Long> {
}
