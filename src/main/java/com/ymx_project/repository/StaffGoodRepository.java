package com.ymx_project.repository;

import com.ymx_project.entity.StaffGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface StaffGoodRepository extends JpaRepository<StaffGoods, String> {

    @Query(value = "SELECT * FROM staff_goods WHERE staff_goods.user_id = :userId",nativeQuery = true)
    List<StaffGoods> findAllByUserId(@Param("userId") String userId);

}
