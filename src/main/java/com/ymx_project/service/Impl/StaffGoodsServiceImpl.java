package com.ymx_project.service.Impl;

import com.ymx_project.entity.StaffGoods;
import com.ymx_project.repository.StaffGoodRepository;
import com.ymx_project.service.StaffGoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StaffGoodsServiceImpl implements StaffGoodsService {

    private final StaffGoodRepository staffGoodRepository;

    public List<StaffGoods> findAllByUserId(String userId){

        return staffGoodRepository.findAllByUserId(userId);
    }
}
