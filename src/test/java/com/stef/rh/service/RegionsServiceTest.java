package com.stef.rh.service;

import com.stef.rh.entity.Regions;
import com.stef.rh.exception.RegionsNotFoundException;
import com.stef.rh.mapper.RegionsMapper;
import com.stef.rh.models.RegionsDto;
import com.stef.rh.repository.RegionsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {RegionsService.class})
@ExtendWith(SpringExtension.class)
class RegionsServiceTest {
   @MockBean
   private RegionsMapper regionsMapper;

   @MockBean
   private RegionsRepository regionsRepository;

   @Autowired
   private RegionsService regionsService;

   @Test
   void testGetAllRegions() {
       when(this.regionsRepository.findAll()).thenReturn(new ArrayList< Regions >());
       ArrayList< RegionsDto > regionsDtoList = new ArrayList<>();
       when(this.regionsMapper.toDtoMap(any())).thenReturn(regionsDtoList);
       List< RegionsDto > actualAllRegions = this.regionsService.getAllRegions();
       assertThat(actualAllRegions).isSameAs(regionsDtoList);
       assertThat(actualAllRegions.isEmpty()).isTrue();
       verify(this.regionsMapper).toDtoMap(any());
       verify(this.regionsRepository).findAll();
   }

   @Test
   void testGetRegionsById() {
       Regions regions = new Regions();
       regions.setRegionId(123L);
       regions.setRegionName("us-east-2");
       Optional< Regions > ofResult = Optional.of(regions);
       when(this.regionsRepository.findById(anyLong())).thenReturn(ofResult);
       RegionsDto regionsDto = new RegionsDto();
       when(this.regionsMapper.toDto(any(Regions.class))).thenReturn(regionsDto);
       assertThat(this.regionsService.getRegionsById(123L)).isSameAs(regionsDto);
       verify(this.regionsMapper).toDto(any(Regions.class));
       verify(this.regionsRepository).findById(anyLong());
   }

   @Test
   void testGetRegionsById2() {
       when(this.regionsRepository.findById(anyLong())).thenReturn(Optional.empty());
       when(this.regionsMapper.toDto(any(Regions.class))).thenReturn(new RegionsDto());
       assertThatExceptionOfType(RegionsNotFoundException.class).isThrownBy(() -> this.regionsService.getRegionsById(123L));
       verify(this.regionsRepository).findById(anyLong());
   }

   @Test
   void testSave() {
       Regions regions = new Regions();
       regions.setRegionId(123L);
       regions.setRegionName("us-east-2");
       when(this.regionsRepository.save(any(Regions.class))).thenReturn(regions);

       Regions regions1 = new Regions();
       regions1.setRegionId(123L);
       regions1.setRegionName("us-east-2");
       RegionsDto regionsDto = new RegionsDto();
       when(this.regionsMapper.toDto(any(Regions.class))).thenReturn(regionsDto);
       when(this.regionsMapper.toNewEntity(any(RegionsDto.class))).thenReturn(regions1);
       assertThat(this.regionsService.save(new RegionsDto())).isSameAs(regionsDto);
       verify(this.regionsMapper).toNewEntity(any(RegionsDto.class));
       verify(this.regionsMapper).toDto(any(Regions.class));
       verify(this.regionsRepository).save(any(Regions.class));
   }

   @Test
   void testDelete() {
       Regions regions = new Regions();
       regions.setRegionId(123L);
       regions.setRegionName("us-east-2");
       Optional< Regions > ofResult = Optional.of(regions);
       doNothing().when(this.regionsRepository).delete(any(Regions.class));
       when(this.regionsRepository.findById(anyLong())).thenReturn(ofResult);
       this.regionsService.delete(123L);
       verify(this.regionsRepository).delete(any(Regions.class));
       verify(this.regionsRepository).findById(anyLong());
   }

    @Test
    void testDelete2() {
        doNothing().when(this.regionsRepository).delete(any(Regions.class));
        when(this.regionsRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThatExceptionOfType(RegionsNotFoundException.class).isThrownBy(() -> this.regionsService.delete(123L));
        verify(this.regionsRepository).findById(anyLong());
    }

   @Test
   void testUpdate() {
       Regions regions = new Regions();
       regions.setRegionId(123L);
       regions.setRegionName("us-east-2");
       Optional< Regions > ofResult = Optional.of(regions);

       Regions regions1 = new Regions();
       regions1.setRegionId(123L);
       regions1.setRegionName("us-east-2");
       when(this.regionsRepository.save(any(Regions.class))).thenReturn(regions1);
       when(this.regionsRepository.findById(anyLong())).thenReturn(ofResult);
       RegionsDto regionsDto = new RegionsDto();
       when(this.regionsMapper.toDto(any(Regions.class))).thenReturn(regionsDto);
       doNothing().when(this.regionsMapper).updateEntity(any(RegionsDto.class), any(Regions.class));
       assertThat(this.regionsService.update(new RegionsDto(), 123L)).isSameAs(regionsDto);
       verify(this.regionsMapper).toDto(any(Regions.class));
       verify(this.regionsMapper).updateEntity(any(RegionsDto.class), any(Regions.class));
       verify(this.regionsRepository).save(any(Regions.class));
       verify(this.regionsRepository).findById(anyLong());
   }

   @Test
   void testUpdate2() {
       Regions regions = new Regions();
       regions.setRegionId(123L);
       regions.setRegionName("us-east-2");
       when(this.regionsRepository.save(any(Regions.class))).thenReturn(regions);
       when(this.regionsRepository.findById(anyLong())).thenReturn(Optional.empty());
       final RegionsDto body = new RegionsDto();
       when(this.regionsMapper.toDto(any(Regions.class))).thenReturn(body);
       Assertions.assertThatThrownBy(() -> this.regionsService.update(body, 123L))
               .isInstanceOf(RegionsNotFoundException.class).hasMessage("la région avec l'ID 123 est introuvable");

   }
}

