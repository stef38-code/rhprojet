package com.stef.rh.service;

import com.stef.rh.mapper.RegionsMapper;
import com.stef.rh.models.RegionsDto;
import com.stef.rh.repository.RegionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RegionsService implements IRegionsService{
    private final RegionsRepository repository;
    private final RegionsMapper regionsMapper;
    @Override
    public List< RegionsDto > getAllRegions() {

        return regionsMapper.toDtoMap(repository.findAll());
    }

    @Override
    public RegionsDto getRegionsById(Long id) {
        return regionsMapper.toDto(repository.findById(id).orElse(null));
    }
}
