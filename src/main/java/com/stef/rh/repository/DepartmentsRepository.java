package com.stef.rh.repository;

import com.stef.rh.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartmentsRepository extends JpaRepository< Departments, Long >, JpaSpecificationExecutor< Departments > {

}