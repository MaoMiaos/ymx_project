package com.ymx_project.service.Impl;

import com.ymx_project.entity.*;
import com.ymx_project.entity.request.CommoditiesTableRequest;
import com.ymx_project.repository.*;
import com.ymx_project.service.CommoditiesTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
//@Slf4j
public class CommoditiesTableServiceImpl implements CommoditiesTableService {
    private final CommoditiesTableRepository commoditiesTableRepository;

    private final ForbidGoodsRepository forbidGoodsRepository;

    private final TortGoodsRepository tortGoodsRepository;

    private final StaffGoodRepository staffGoodRepository;

    private final NewCommoditiesRepository newCommoditiesRepository;

    private final RemoveBRepository removeBRepository;

    private final CheapGoodsRepository cheapGoodsRepository;

    private final RepeatGoodsRepository repeatGoodsRepository;

    @Override
    public CommoditiesTable getRandomData(String userId) {
        CommoditiesTable commoditiesTable =commoditiesTableRepository.firstFindRandom(userId);
        if (commoditiesTable == null){
            //再拿一遍
            commoditiesTable = commoditiesTableRepository.findRandom();
            commoditiesTableRepository.updateUserIdByAsin(commoditiesTable.getAsin(),userId);
        }
        return commoditiesTable;
    }

    @Override
    public void addCommodities(CommoditiesTableRequest commoditiesTableRequest) throws ParseException {
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time = sdf.parse( nowTime );
        switch (commoditiesTableRequest.getType()){
            case "Rflag":
                RemoveB removeB = new RemoveB();
                removeB.setAsin(commoditiesTableRequest.getASIN());
                removeB.setBrand(commoditiesTableRequest.getBrand());
                removeB.setAsinLink(commoditiesTableRequest.getASIN_link());
                removeB.setCreateData(time);
                removeBRepository.save(removeB);
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                break;
            case "xuan":
                String nullUserId = null;
                CommoditiesTable commoditiesTable = new CommoditiesTable();
                commoditiesTable.setAsin(commoditiesTableRequest.getASIN());
                commoditiesTable.setBrand(commoditiesTableRequest.getBrand());
                commoditiesTable.setHeight(commoditiesTableRequest.getHeight());
                commoditiesTable.setPrice(commoditiesTableRequest.getPrice());
                commoditiesTable.setCreateData(time);
                commoditiesTable.setGoodsType(commoditiesTableRequest.getGoods_count());
                commoditiesTable.setPicture_link(commoditiesTableRequest.getPic_link());
                commoditiesTable.setAsinLink(commoditiesTableRequest.getASIN_link());
                commoditiesTable.setUserId(nullUserId);
                commoditiesTable.setFbaValue(commoditiesTableRequest.getFBA_value());
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                commoditiesTableRepository.save(commoditiesTable);
                break;
            case "jin":
                ForbidGoods forbidGoods = new ForbidGoods();
                forbidGoods.setAsin(commoditiesTableRequest.getASIN());
                forbidGoods.setBrand(commoditiesTableRequest.getBrand());
                forbidGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
                forbidGoods.setFbaValue(commoditiesTableRequest.getFBA_value());
                forbidGoods.setGoodsType(commoditiesTableRequest.getGoods_count());
                forbidGoods.setCreateData(time);
                forbidGoods.setHeight(commoditiesTableRequest.getHeight());
                forbidGoods.setPrice(commoditiesTableRequest.getPrice());
                forbidGoods.setOutType("null");
                forbidGoods.setPicture_link(commoditiesTableRequest.getPic_link());
                forbidGoodsRepository.save(forbidGoods);
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                break;
            case "wei":
                TortGoods tortGoods = new TortGoods();
                tortGoods.setAsin(commoditiesTableRequest.getASIN());
                tortGoods.setBrand(commoditiesTableRequest.getBrand());
                tortGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
                tortGoods.setGoodsType(commoditiesTableRequest.getGoods_count());
                tortGoods.setCreateData(time);
                tortGoods.setHeight(commoditiesTableRequest.getHeight());
                tortGoods.setPrice(commoditiesTableRequest.getPrice());
                tortGoods.setFbaValue(commoditiesTableRequest.getFBA_value());
                tortGoods.setOutType("null");
                tortGoods.setPicture_link(commoditiesTableRequest.getPic_link());
                tortGoodsRepository.save(tortGoods);
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                break;
            case "chu":
                StaffGoods staffGoods =new StaffGoods();
                staffGoods.setAsin(commoditiesTableRequest.getASIN());
                staffGoods.setBrand(commoditiesTableRequest.getBrand());
                staffGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
                staffGoods.setCreateData(time);
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
                staffGoodRepository.save(staffGoods);
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                break;
            case "xin":
                NewCommodities newCommodities =new NewCommodities();
                newCommodities.setAsin(commoditiesTableRequest.getASIN());
                newCommodities.setBrand(commoditiesTableRequest.getBrand());
                newCommodities.setAsinLink(commoditiesTableRequest.getASIN_link());
                newCommodities.setGoodsType(commoditiesTableRequest.getGoods_count());
                newCommodities.setCreateData(time);
                newCommodities.setHeight(commoditiesTableRequest.getHeight());
                newCommodities.setPrice(commoditiesTableRequest.getPrice());
                newCommodities.setPicture_link(commoditiesTableRequest.getPic_link());
                newCommodities.setFbaValue(commoditiesTableRequest.getFBA_value());
                newCommoditiesRepository.save(newCommodities);
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                break;
            case "cheap":
                CheapGoods cheapGoods = new CheapGoods();
                cheapGoods.setAsin(commoditiesTableRequest.getASIN());
                cheapGoods.setBrand(commoditiesTableRequest.getBrand());
                cheapGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
                cheapGoods.setGoodsCount(commoditiesTableRequest.getGoods_count());
                cheapGoods.setCreateData(time);
                cheapGoods.setFbaValue(commoditiesTableRequest.getFBA_value());
                cheapGoods.setHeight(commoditiesTableRequest.getHeight());
                cheapGoods.setPrice(commoditiesTableRequest.getPrice());
                cheapGoods.setPicture_link(commoditiesTableRequest.getPic_link());
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                cheapGoodsRepository.save(cheapGoods);
                break;
            case "repeat":
                RepeatGoods repeatGoods = new RepeatGoods();
                repeatGoods.setAsin(commoditiesTableRequest.getASIN());
                repeatGoods.setBrand(commoditiesTableRequest.getBrand());
                repeatGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
                repeatGoods.setGoodsCount(commoditiesTableRequest.getGoods_count());
                repeatGoods.setCreateData(time);
                repeatGoods.setFbaValue(commoditiesTableRequest.getFBA_value());
                repeatGoods.setHeight(commoditiesTableRequest.getHeight());
                repeatGoods.setPrice(commoditiesTableRequest.getPrice());
                repeatGoods.setPicture_link(commoditiesTableRequest.getPic_link());
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                repeatGoodsRepository.save(repeatGoods);
            default:
        }


    }


}
