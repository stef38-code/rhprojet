package com.stef.rh.service;

import com.stef.rh.dto.RegionsDto;

import java.util.List;

public interface IRegionsService {
    List< RegionsDto > getAllRegions();

    RegionsDto getRegionsById(Long id);

    RegionsDto save(RegionsDto body);

    void delete(Long id);

    RegionsDto update(RegionsDto body, Long id);
}
