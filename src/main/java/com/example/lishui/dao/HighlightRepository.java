package com.example.lishui.dao;

import com.example.lishui.dao.entity.Highlight;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/10 下午4:08
 */
public interface HighlightRepository extends JpaRepository<Highlight,Long> {
}
