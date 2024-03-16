package com.ymx_project.mapper;

import com.ymx_project.entity.*;
import com.ymx_project.request.CommoditiesTableRequest;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

//@Mapper(componentModel = "spring")
//封装成包在Controller使用
//@Component
public interface CommoditiesTableRequestMapper {

    RemoveB toRemoveB(CommoditiesTableRequest commoditiesTableRequest);

    CommoditiesTable toCommoditiesTable(CommoditiesTableRequest commoditiesTableRequest);

    ForbidGoods toForbidGoods(CommoditiesTableRequest commoditiesTableRequest);

    TortGoods toTortGoods (CommoditiesTableRequest commoditiesTableRequest);

    StaffGoods toStaffGoods(CommoditiesTableRequest commoditiesTableRequest);

    NewCommodities toNewCommodities(CommoditiesTableRequest commoditiesTableRequest);

    CheapGoods toCheapGoods(CommoditiesTableRequest commoditiesTableRequest);

    RepeatGoods toRepeatGoods(CommoditiesTableRequest commoditiesTableRequest);

}
