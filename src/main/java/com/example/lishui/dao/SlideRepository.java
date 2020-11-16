package com.example.lishui.dao;

import com.example.lishui.dao.entity.Slide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jesse on 2020/11/16 下午3:39
 */
@Repository
public interface SlideRepository extends JpaRepository<Slide, Long> {

}
