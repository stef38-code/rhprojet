package com.stef.rh.repository;

import com.stef.rh.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JobsRepository extends JpaRepository< Jobs, Long >, JpaSpecificationExecutor< Jobs > {

}