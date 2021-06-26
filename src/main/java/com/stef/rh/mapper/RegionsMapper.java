package com.stef.rh.mapper;

import com.stef.rh.dto.RegionsDto;
import com.stef.rh.model.Regions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionsMapper {
    @Mapping(target = "regionId", source = "regionId")
    RegionsDto toDto(Regions region);

    List< RegionsDto > toDtoMap(List< Regions > regions);

    Regions toNewEntity(RegionsDto regionsDto);

    void updateEntity(RegionsDto regionsDto, @MappingTarget Regions region);
}
