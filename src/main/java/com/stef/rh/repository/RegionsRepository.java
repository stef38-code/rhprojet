package com.stef.rh.repository;

import com.stef.rh.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegionsRepository extends JpaRepository< Regions, Long >, JpaSpecificationExecutor< Regions > {

}