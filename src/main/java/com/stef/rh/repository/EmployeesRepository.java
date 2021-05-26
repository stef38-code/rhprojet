package com.stef.rh.repository;

import com.stef.rh.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeesRepository extends JpaRepository< Employees, Long >, JpaSpecificationExecutor< Employees > {

}