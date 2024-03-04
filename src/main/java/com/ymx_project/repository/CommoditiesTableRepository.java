package com.ymx_project.repository;

import com.ymx_project.entity.CommoditiesTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommoditiesTableRepository extends JpaRepository<CommoditiesTable,String > {
    @Query(value = "SELECT DISTINCT * FROM commodities_table WHERE user_id is null ORDER BY RAND() LIMIT 1",nativeQuery = true)
    CommoditiesTable findRandom();

    @Query(value = "SELECT DISTINCT * FROM commodities_table WHERE user_id = :user_id LIMIT 1" ,nativeQuery = true)
    CommoditiesTable firstFindRandom(@Param("user_id") String user_id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM commodities_table WHERE commodities_table.asin = :asin",nativeQuery = true)
    void deleteByASIN(@Param("asin")String asin);

    @Transactional
    @Modifying
    @Query(value = "UPDATE commodities_table SET commodities_table.user_id = :userId WHERE commodities_table.ASIN = :asin",nativeQuery = true)
    void updateUserIdByAsin(@Param("asin")String asin, @Param("userId")String userId);

}
