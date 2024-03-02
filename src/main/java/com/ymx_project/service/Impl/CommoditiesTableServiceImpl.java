package com.ymx_project.service.Impl;

import com.ymx_project.entity.*;
import com.ymx_project.entity.request.CommoditiesTableRequest;
import com.ymx_project.repository.*;
import com.ymx_project.service.CommoditiesTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommoditiesTableServiceImpl implements CommoditiesTableService {

    private final CommoditiesTableRepository commoditiesTableRepository;

    private final ForbidGoodsRepository forbidGoodsRepository;

    private final TortGoodsRepository tortGoodsRepository;

    private final StaffGoodRepository staffGoodRepository;

    private final NewCommoditiesRepository newCommoditiesRepository;

    private final RemoveBRepository removeBRepository;


    @Override
    public List<CommoditiesTable> findAllByUserId(String userId){
        return commoditiesTableRepository.findAllByUserId(userId);
    }


    @Override
    public CommoditiesTable getRandomData() {
        return commoditiesTableRepository.findRandom();

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
                commoditiesTableRepository.deletebyASIN(commoditiesTableRequest.getASIN());
                break;
            case "xuan":
                CommoditiesTable commoditiesTable = new CommoditiesTable();
                commoditiesTable.setAsin(commoditiesTableRequest.getASIN());
                commoditiesTable.setBrand(commoditiesTableRequest.getBrand());
                commoditiesTable.setHeight(commoditiesTableRequest.getHeight());
                commoditiesTable.setPrice(commoditiesTableRequest.getPrice());
                commoditiesTable.setCreateData(time);
                commoditiesTable.setGoodsType(commoditiesTableRequest.getGoods_count());
                commoditiesTable.setPicture_link(commoditiesTableRequest.getPic_link());
                commoditiesTable.setAsinLink(commoditiesTable.getAsinLink());
                commoditiesTable.setUserId("null");
                commoditiesTable.setFbaValue(commoditiesTableRequest.getFBA_value());
                commoditiesTableRepository.deletebyASIN(commoditiesTableRequest.getASIN());
                commoditiesTableRepository.save(commoditiesTable);
                break;
            case "jin":
                ForbidGoods forbidGoods = new ForbidGoods();
                forbidGoods.setAsin(commoditiesTableRequest.getASIN());
                forbidGoods.setBrand(commoditiesTableRequest.getBrand());
                forbidGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
                forbidGoods.setGoodsType(commoditiesTableRequest.getType());
                forbidGoods.setCreateData(time);
                forbidGoods.setHeight(commoditiesTableRequest.getHeight());
                forbidGoods.setPrice(commoditiesTableRequest.getPrice());
                forbidGoods.setOutType("null");
                forbidGoods.setPicture_link(commoditiesTableRequest.getPic_link());
                forbidGoodsRepository.save(forbidGoods);
                commoditiesTableRepository.deletebyASIN(commoditiesTableRequest.getASIN());
                break;
            case "wei":
                TortGoods tortGoods = new TortGoods();
                tortGoods.setAsin(commoditiesTableRequest.getASIN());
                tortGoods.setBrand(commoditiesTableRequest.getBrand());
                tortGoods.setAsinLink(commoditiesTableRequest.getASIN_link());
                tortGoods.setGoodsType(commoditiesTableRequest.getType());
                tortGoods.setCreateData(time);
                tortGoods.setHeight(commoditiesTableRequest.getHeight());
                tortGoods.setPrice(commoditiesTableRequest.getPrice());
                tortGoods.setOutType("null");
                tortGoods.setPicture_link(commoditiesTableRequest.getPic_link());
                tortGoodsRepository.save(tortGoods);
                commoditiesTableRepository.deletebyASIN(commoditiesTableRequest.getASIN());
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
                staffGoodRepository.save(staffGoods);
                commoditiesTableRepository.deletebyASIN(commoditiesTableRequest.getASIN());
                break;
            case "xin":
                NewCommodities newCommodities =new NewCommodities();
                newCommodities.setAsin(commoditiesTableRequest.getASIN());
                newCommodities.setBrand(commoditiesTableRequest.getBrand());
                newCommodities.setAsinLink(commoditiesTableRequest.getASIN_link());
                newCommodities.setGoodsType(commoditiesTableRequest.getType());
                newCommodities.setCreateData(time);
                newCommodities.setHeight(commoditiesTableRequest.getHeight());
                newCommodities.setPrice(commoditiesTableRequest.getPrice());
                newCommodities.setPicture_link(commoditiesTableRequest.getPic_link());
                newCommoditiesRepository.save(newCommodities);
                commoditiesTableRepository.deletebyASIN(commoditiesTableRequest.getASIN());
                break;
            default:
        }


    }


}
