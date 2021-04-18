package com.stef.rh.service;

import com.stef.rh.models.RegionsDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRegionsService {
    List< com.stef.rh.models.RegionsDto > getAllRegions();

    RegionsDto getRegionsById(Long id);

     RegionsDto save(RegionsDto body);
}
