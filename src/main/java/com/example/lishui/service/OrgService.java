package com.example.lishui.service;

import com.example.lishui.dao.entity.Org;
import org.springframework.stereotype.Service;

/**
 * Created by jesse on 2020/12/14 下午2:54
 */
public interface OrgService {
    Org getOrg();
    Org updateOrg(Org org);
}
