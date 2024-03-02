package com.ymx_project.service;

import com.ymx_project.entity.StaffGoods;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface StaffGoodsService {

    List<StaffGoods> findAllByUserId(String userId);
}
