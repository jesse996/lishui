package com.example.lishui.service.impl;

import com.example.lishui.dao.OrgRepository;
import com.example.lishui.dao.entity.Org;
import com.example.lishui.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/14 下午2:56
 */
@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    OrgRepository orgRepository;

    @Override
    public Org getOrg() {
        Optional<Org> optional = orgRepository.findById(1L);
        if (optional.isEmpty()) {
            return orgRepository.save(new Org(1L, "",""));
        }else {
            return optional.get();
        }
    }

    @Override
    public Org updateOrg(Org org) {
        org.setId(1L);
        return orgRepository.save(org);
    }
}
