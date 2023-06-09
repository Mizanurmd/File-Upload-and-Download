package com.Spring.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.file.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
