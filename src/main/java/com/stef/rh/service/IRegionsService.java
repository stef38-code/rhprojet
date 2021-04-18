package com.stef.rh.service;

import com.stef.rh.models.RegionsDto;

import java.util.List;

public interface IRegionsService {
    List< com.stef.rh.models.RegionsDto > getAllRegions();

    RegionsDto getRegionsById(Long id);
}
