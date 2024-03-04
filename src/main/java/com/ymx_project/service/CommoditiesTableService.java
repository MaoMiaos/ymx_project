package com.ymx_project.service;

import com.ymx_project.entity.CommoditiesTable;
import com.ymx_project.entity.request.CommoditiesTableRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface CommoditiesTableService {


    CommoditiesTable getRandomData(String userId);

    void addCommodities(CommoditiesTableRequest commoditiesTableRequest) throws ParseException;
}
