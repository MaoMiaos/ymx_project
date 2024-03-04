package com.ymx_project.util;

import com.ymx_project.repository.*;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class FilterData {
    private final AllTableRepository allTableRepository;
    private final RemoveBRepository removeBRepository;
    private final RemoveARepository removeARepository;
    private final ReSelectRepository reSelectRepository;
    private final CommoditiesTableRepository commoditiesTableRepository;
    private final NewCommoditiesRepository newCommoditiesRepository;
    private final TortGoodsRepository tortGoodsRepository;
    private final ForbidGoodsRepository forbidGoodsRepository;


    public boolean isPresent(String tableName,String data){
        switch (tableName) {
            // 这里需要设置不关闭流
            case "all_table":
                return allTableRepository.findCountByAsin(data);
            case "remove_a":
                return removeARepository.findCountByAsin(data);
            case "remove_b":
                return removeARepository.findCountByAsin(data);
            case "re_select":
                return removeARepository.findCountByAsin(data);
            case "commodities_table":
                return removeARepository.findCountByAsin(data);
            case "new_commodities":
                return removeARepository.findCountByAsin(data);
            case "forbid_goods":
                return removeARepository.findCountByAsin(data);
            case "tort_goods":
                return removeARepository.findCountByAsin(data);
        }
        return false;
    }


}
