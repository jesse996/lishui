package com.example.lishui.dao;

import com.example.lishui.dao.entity.Announcement;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/10 下午3:58
 */
//@Api(tags = "jjjjjjjjjjj")
@Tag(name = "公告接口",description = "公告接口描述")
public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
}
