package com.example.lishui.service.impl;

import com.example.lishui.dao.ReformNumberRepository;
import com.example.lishui.dao.entity.Org;
import com.example.lishui.dao.entity.ReformNumber;
import com.example.lishui.service.ReformNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/14 下午3:15
 */
@Service
public class ReformNumberServiceImpl implements ReformNumberService {
    @Autowired
    ReformNumberRepository reformNumberRepository;

    @Override
    public ReformNumber getReformNumber() {
        Optional<ReformNumber> optional = reformNumberRepository.findById(1L);
        if (optional.isEmpty()) {
            return reformNumberRepository.save(new ReformNumber(1L, ""));
        }else {
            return optional.get();
        }
    }

    @Override
    public ReformNumber updateReformNumber(ReformNumber reformNumber) {
        reformNumber.setId(1L);
        return reformNumberRepository.save(reformNumber);
    }
}
