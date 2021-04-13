package com.stef.rh.repository;

import com.stef.rh.entity.Dependents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DependentsRepository extends JpaRepository< Dependents, Long >, JpaSpecificationExecutor< Dependents > {

}