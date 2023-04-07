package com.Spring.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.file.model.EmployeeDetail;

@Repository
public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetail, Long>{

}
