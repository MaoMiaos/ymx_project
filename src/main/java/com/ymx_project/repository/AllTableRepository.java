package com.ymx_project.repository;

import com.ymx_project.entity.AllTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AllTableRepository extends JpaRepository<AllTable,String> {

}
