package com.example.lishui.dao;

import com.example.lishui.dao.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jesse on 2020/11/16 下午7:21
 */
@Repository
public interface OptionRepository extends JpaRepository<Option,Long> {
}
