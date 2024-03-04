package com.ymx_project.repository;

import com.ymx_project.entity.RemoveA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RemoveARepository extends JpaRepository<RemoveA,String> {

    @Query(value = "SELECT ASIN FROM all_table WHERE ASIN = :asin Limit 1",nativeQuery = true)
    boolean findCountByAsin(String data);
}
