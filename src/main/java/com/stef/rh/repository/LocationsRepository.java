package com.stef.rh.repository;

import com.stef.rh.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocationsRepository extends JpaRepository< Locations, Long >, JpaSpecificationExecutor< Locations > {

}