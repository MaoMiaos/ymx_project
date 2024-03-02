package com.ymx_project.repository;

import com.ymx_project.entity.StaffGoods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface StaffGoodRepository extends JpaRepository<StaffGoods, String> {

    List<StaffGoods> findAllByUserId(String userId);

}
