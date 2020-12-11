package com.example.lishui.dao;

import com.example.lishui.dao.entity.AnnouncementRule;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/10 下午4:01
 */
//@Api(tags = {"公告规则接口"})
public interface AnnouncementRuleRepository extends JpaRepository<AnnouncementRule,Long> {
}
