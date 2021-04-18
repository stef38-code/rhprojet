package com.stef.rh.mapper;

import com.stef.rh.entity.Regions;
import com.stef.rh.models.RegionsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionsMapper {
    @Mapping(target = "id", source = "regionId")
    RegionsDto toDto(Regions region);
    List<RegionsDto> toDtoMap(List<Regions> regions);
}
