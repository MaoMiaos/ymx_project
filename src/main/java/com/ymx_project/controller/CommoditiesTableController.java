package com.ymx_project.controller;

import com.ymx_project.entity.CommoditiesTable;
import com.ymx_project.repository.CommoditiesTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/staff")
public class CommoditiesTableController {

    private final CommoditiesTableRepository commoditiesTableRepository;

    @PostMapping("update_commodities")
    String addCommodities(@RequestBody CommoditiesTable commoditiesTable){
        commoditiesTableRepository.save(commoditiesTable);
        return "OK";
    }


}
