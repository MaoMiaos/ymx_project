package com.ymx_project.service.Impl;

import com.ymx_project.entity.*;
import com.ymx_project.mapper.CommoditiesTableRequestMapper;
import com.ymx_project.request.CommoditiesTableRequest;
import com.ymx_project.repository.*;
import com.ymx_project.service.CommoditiesTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    private final CommoditiesTableRequestMapper commoditiesTableRequestMapper;

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
        commoditiesTableRequest.setCreateData(time);
        switch (commoditiesTableRequest.getType()){
            case "Rflag":
                removeBRepository.save(commoditiesTableRequestMapper.toRemoveB(commoditiesTableRequest));
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                break;
            case "xuan":
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                commoditiesTableRepository.save(commoditiesTableRequestMapper.toCommoditiesTable(commoditiesTableRequest));
                break;
            case "jin":
                forbidGoodsRepository.save(commoditiesTableRequestMapper.toForbidGoods(commoditiesTableRequest));
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                break;
            case "wei":
                tortGoodsRepository.save(commoditiesTableRequestMapper.toTortGoods(commoditiesTableRequest));
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                break;
            case "chu":
                StaffGoods staffGoods = commoditiesTableRequestMapper.toStaffGoods(commoditiesTableRequest);
                staffGoodRepository.save(staffGoods);
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                break;
            case "xin":
                newCommoditiesRepository.save(commoditiesTableRequestMapper.toNewCommodities(commoditiesTableRequest));
                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                break;
            case "cheap":

                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                cheapGoodsRepository.save(commoditiesTableRequestMapper.toCheapGoods(commoditiesTableRequest));
                break;
            case "repeat":

                commoditiesTableRepository.deleteByASIN(commoditiesTableRequest.getASIN());
                repeatGoodsRepository.save(commoditiesTableRequestMapper.toRepeatGoods(commoditiesTableRequest));
            default:
        }


    }


}
