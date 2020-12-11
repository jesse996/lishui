package com.example.lishui.dao;

import com.example.lishui.dao.entity.Org;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/10 下午3:41
 */
public interface OrgRepository extends JpaRepository<Org,Long> {
}
