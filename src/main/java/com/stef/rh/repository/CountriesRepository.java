package com.stef.rh.repository;

import com.stef.rh.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountriesRepository extends JpaRepository< Countries, String >, JpaSpecificationExecutor< Countries > {

}