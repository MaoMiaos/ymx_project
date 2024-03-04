package com.ymx_project.repository;

import com.ymx_project.entity.AllTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AllTableRepository extends JpaRepository<AllTable,String> {

    @Query(value = "SELECT ASIN FROM all_table WHERE ASIN = :asin LIMIT 1",nativeQuery = true)
    boolean findCountByAsin(@Param("asin") String data);
}
