package com.ymx_project.repository;

import com.ymx_project.entity.CommoditiesTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CommoditiesTableRepository extends JpaRepository<CommoditiesTable,String > {
    @Query(value = "SELECT DISTINCT * FROM commodities_table ORDER BY RAND() LIMIT 1",nativeQuery = true)
    CommoditiesTable findRandom();

    List<CommoditiesTable> findAllByUserId(String userid);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM commodities_table WHERE commodities_table.asin = :asin",nativeQuery = true)
    void deletebyASIN(@Param("asin")String asin);

    @Modifying
    @Query(value = "UPDATE commodities_table SET commodities_table.user_id='null' WHERE commodities_table.asin = :asin",nativeQuery = true)
    void updateUserId(@Param("asin")String asin);
}
