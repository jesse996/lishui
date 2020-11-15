package com.example.lishui.dao;

import com.example.lishui.dao.entity.PageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jesse on 2020/11/15 下午8:27
 */
@Repository
public interface PageInfoRepository extends JpaRepository<PageInfo,Long> {
}
