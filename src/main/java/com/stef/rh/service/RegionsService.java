package com.stef.rh.service;

import com.stef.rh.entity.Regions;
import com.stef.rh.exception.ErrorCode;
import com.stef.rh.exception.RegionsNotFoundException;
import com.stef.rh.mapper.RegionsMapper;
import com.stef.rh.models.RegionsDto;
import com.stef.rh.repository.RegionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RegionsService implements IRegionsService {
    private final RegionsRepository repository;
    private final RegionsMapper regionsMapper;
    private Regions regions;
    @Override
    public List< RegionsDto > getAllRegions() {
        return regionsMapper.toDtoMap(repository.findAll());
    }

    @Override
    public RegionsDto getRegionsById(Long id) {
        return regionsMapper.toDto(getRegion(id));
    }


    @Override
    public RegionsDto save(RegionsDto body) {
        regions = regionsMapper.toNewEntity(body);
        return regionsMapper.toDto(repository.save(regions));
    }

    @Override
    public void delete(Long id) {
        regions = getRegion(id);
        repository.delete(regions);
    }

    @Override
    public RegionsDto update(RegionsDto body, Long id) {
        Regions region = getRegion(id);
        regionsMapper.updateEntity(body, region);
        return regionsMapper.toDto(repository.save(region));
    }

    /**
     * Recherche si la region existe en DB
     *
     * @param id identifiant de la region
     * @return Regions
     */
    private Regions getRegion(Long id) {
        return repository.findById(id).orElseThrow(() -> new RegionsNotFoundException(ErrorCode.APPLICATIF, id));
    }
}
