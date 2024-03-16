package com.ymx_project.mapper.Impl;

import com.ymx_project.entity.*;
import com.ymx_project.mapper.CommoditiesTableRequestMapper;
import com.ymx_project.request.CommoditiesTableRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class CommoditiesTableRequestMapperImpl implements CommoditiesTableRequestMapper {
    @Override
    public RemoveB toRemoveB(CommoditiesTableRequest commoditiesTableRequest) {
        RemoveB removeB = new RemoveB();
        removeB.setAsin(commoditiesTableRequest.getASIN());
        removeB.setBrand(commoditiesTableRequest.getBrand());
        removeB.setAsinLink(commoditiesTableRequest.getASIN_link());
        removeB.setCreateData(commoditiesTableRequest.getCreateData());
        return removeB;
    }

    @Override
    public CommoditiesTable toCommoditiesTable(CommoditiesTableRequest commoditiesTableRequest) {
        CommoditiesTable commoditiesTable = new CommoditiesTable();
        commoditiesTable.setAsin(commoditiesTableRequest.getASIN());
        commoditiesTable.setBrand(commoditiesTableRequest.getBrand());
        commoditiesTable.setHeight(commoditiesTableRequest.getHeight());
        commoditiesTable.setPrice(commoditiesTableRequest.getPrice());
        commoditiesTable.setCreateData(commoditiesTableRequest.getCreateData());
        commoditiesTable.setGoodsType(commoditiesTableRequest.getGoods_count());
        commoditiesTable.setPicture_link(commoditiesTableRequest.getPic_link());
        commoditiesTable.setAsinLink(commoditiesTableRequest.getASIN_link());
        commoditiesTable.setUserId(null);
        commoditiesTable.setFbaValue(commoditiesTableRequest.getFBA_value());
        return commoditiesTable;
    }

    @Override
    public ForbidGoods toForbidGoods(CommoditiesTableRequest commoditiesTableRequest) {
        ForbidGoods forbidGoods = new ForbidGoods();
        forbidGoods.setAsin(commoditiesTableRequest.getASIN());
        forbidGoods.setBrand(commoditiesTableRequest.getBrand());
        forbidGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
        forbidGoods.setFbaValue(commoditiesTableRequest.getFBA_value());
        forbidGoods.setGoodsType(commoditiesTableRequest.getGoods_count());
        forbidGoods.setCreateData(commoditiesTableRequest.getCreateData());
        forbidGoods.setHeight(commoditiesTableRequest.getHeight());
        forbidGoods.setPrice(commoditiesTableRequest.getPrice());
        forbidGoods.setOutType(null);
        forbidGoods.setPicture_link(commoditiesTableRequest.getPic_link());
        return forbidGoods;
    }

    @Override
    public TortGoods toTortGoods(CommoditiesTableRequest commoditiesTableRequest) {
        TortGoods tortGoods = new TortGoods();
        tortGoods.setAsin(commoditiesTableRequest.getASIN());
        tortGoods.setBrand(commoditiesTableRequest.getBrand());
        tortGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
        tortGoods.setGoodsType(commoditiesTableRequest.getGoods_count());
        tortGoods.setCreateData(commoditiesTableRequest.getCreateData());
        tortGoods.setHeight(commoditiesTableRequest.getHeight());
        tortGoods.setPrice(commoditiesTableRequest.getPrice());
        tortGoods.setFbaValue(commoditiesTableRequest.getFBA_value());
        tortGoods.setOutType(null);
        tortGoods.setPicture_link(commoditiesTableRequest.getPic_link());
        return tortGoods;
    }

    @Override
    public StaffGoods toStaffGoods(CommoditiesTableRequest commoditiesTableRequest) {
        StaffGoods staffGoods =new StaffGoods();
        staffGoods.setAsin(commoditiesTableRequest.getASIN());
        staffGoods.setBrand(commoditiesTableRequest.getBrand());
        staffGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
        staffGoods.setCreateData(commoditiesTableRequest.getCreateData());
        staffGoods.setHeight(commoditiesTableRequest.getHeight());
        staffGoods.setPrice(commoditiesTableRequest.getPrice());
        staffGoods.setPicture_link(commoditiesTableRequest.getPic_link());
        staffGoods.setGoodsCount(commoditiesTableRequest.getGoods_count());
        staffGoods.setHuilv(commoditiesTableRequest.getHuilv());
        staffGoods.setCaigouCount(commoditiesTableRequest.getCaigou_count());
        staffGoods.setCaigouPrice(commoditiesTableRequest.getCaigou_price());
        staffGoods.setFbaValue(commoditiesTableRequest.getFBA_value());
        staffGoods.setCaigouLink(commoditiesTableRequest.getCaigou_link());
        staffGoods.setUserId(commoditiesTableRequest.getUser_id());
        return staffGoods;
    }

    @Override
    public NewCommodities toNewCommodities(CommoditiesTableRequest commoditiesTableRequest) {
        NewCommodities newCommodities =new NewCommodities();
        newCommodities.setAsin(commoditiesTableRequest.getASIN());
        newCommodities.setBrand(commoditiesTableRequest.getBrand());
        newCommodities.setAsinLink(commoditiesTableRequest.getASIN_link());
        newCommodities.setGoodsType(commoditiesTableRequest.getGoods_count());
        newCommodities.setCreateData(commoditiesTableRequest.getCreateData());
        newCommodities.setHeight(commoditiesTableRequest.getHeight());
        newCommodities.setPrice(commoditiesTableRequest.getPrice());
        newCommodities.setPicture_link(commoditiesTableRequest.getPic_link());
        newCommodities.setFbaValue(commoditiesTableRequest.getFBA_value());
        return newCommodities;
    }

    @Override
    public CheapGoods toCheapGoods(CommoditiesTableRequest commoditiesTableRequest) {
        CheapGoods cheapGoods = new CheapGoods();
        cheapGoods.setAsin(commoditiesTableRequest.getASIN());
        cheapGoods.setBrand(commoditiesTableRequest.getBrand());
        cheapGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
        cheapGoods.setGoodsCount(commoditiesTableRequest.getGoods_count());
        cheapGoods.setCreateData(commoditiesTableRequest.getCreateData());
        cheapGoods.setFbaValue(commoditiesTableRequest.getFBA_value());
        cheapGoods.setHeight(commoditiesTableRequest.getHeight());
        cheapGoods.setPrice(commoditiesTableRequest.getPrice());
        cheapGoods.setPicture_link(commoditiesTableRequest.getPic_link());
        return cheapGoods;
    }

    @Override
    public RepeatGoods toRepeatGoods(CommoditiesTableRequest commoditiesTableRequest) {
        RepeatGoods repeatGoods = new RepeatGoods();
        repeatGoods.setAsin(commoditiesTableRequest.getASIN());
        repeatGoods.setBrand(commoditiesTableRequest.getBrand());
        repeatGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
        repeatGoods.setGoodsCount(commoditiesTableRequest.getGoods_count());
        repeatGoods.setCreateData(commoditiesTableRequest.getCreateData());
        repeatGoods.setFbaValue(commoditiesTableRequest.getFBA_value());
        repeatGoods.setHeight(commoditiesTableRequest.getHeight());
        repeatGoods.setPrice(commoditiesTableRequest.getPrice());
        repeatGoods.setPicture_link(commoditiesTableRequest.getPic_link());
        return repeatGoods;
    }
}
