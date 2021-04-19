package com.stef.rh.service;

import com.stef.rh.entity.Regions;
import com.stef.rh.exception.RegionsNotFoundException;
import com.stef.rh.mapper.RegionsMapper;
import com.stef.rh.models.RegionsDto;
import com.stef.rh.repository.RegionsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {RegionsService.class})
@ExtendWith(SpringExtension.class)
public class RegionsServiceTest {
    @MockBean
    private RegionsMapper regionsMapper;

    @MockBean
    private RegionsRepository regionsRepository;

    @Autowired
    private RegionsService regionsService;

    @Test
    public void testGetAllRegions() {
        when(this.regionsRepository.findAll()).thenReturn(new ArrayList< Regions >());
        ArrayList< RegionsDto > regionsDtoList = new ArrayList< RegionsDto >();
        when(this.regionsMapper.toDtoMap((List< Regions >) any())).thenReturn(regionsDtoList);
        List< RegionsDto > actualAllRegions = this.regionsService.getAllRegions();
        assertSame(regionsDtoList, actualAllRegions);
        assertTrue(actualAllRegions.isEmpty());
        verify(this.regionsMapper).toDtoMap((List< Regions >) any());
        verify(this.regionsRepository).findAll();
    }

    @Test
    public void testGetRegionsById() {
        Regions regions = new Regions();
        regions.setRegionId(123L);
        regions.setRegionName("us-east-2");
        Optional< Regions > ofResult = Optional.< Regions >of(regions);
        when(this.regionsRepository.findById((Long) any())).thenReturn(ofResult);
        RegionsDto regionsDto = new RegionsDto();
        when(this.regionsMapper.toDto((Regions) any())).thenReturn(regionsDto);
        assertSame(regionsDto, this.regionsService.getRegionsById(123L));
        verify(this.regionsMapper).toDto((Regions) any());
        verify(this.regionsRepository).findById((Long) any());
    }

    @Test
    public void testGetRegionsById2() {
        when(this.regionsRepository.findById((Long) any())).thenReturn(Optional.< Regions >empty());
        when(this.regionsMapper.toDto((Regions) any())).thenReturn(new RegionsDto());
        assertThrows(RegionsNotFoundException.class, () -> this.regionsService.getRegionsById(123L));
        verify(this.regionsRepository).findById((Long) any());
    }

    @Test
    public void testSave() {
        Regions regions = new Regions();
        regions.setRegionId(123L);
        regions.setRegionName("us-east-2");
        when(this.regionsRepository.save((Regions) any())).thenReturn(regions);

        Regions regions1 = new Regions();
        regions1.setRegionId(123L);
        regions1.setRegionName("us-east-2");
        RegionsDto regionsDto = new RegionsDto();
        when(this.regionsMapper.toDto((Regions) any())).thenReturn(regionsDto);
        when(this.regionsMapper.toNewEntity((RegionsDto) any())).thenReturn(regions1);
        assertSame(regionsDto, this.regionsService.save(new RegionsDto()));
        verify(this.regionsMapper).toNewEntity((RegionsDto) any());
        verify(this.regionsMapper).toDto((Regions) any());
        verify(this.regionsRepository).save((Regions) any());
    }

    @Test
    public void testDelete() {
        Regions regions = new Regions();
        regions.setRegionId(123L);
        regions.setRegionName("us-east-2");
        Optional< Regions > ofResult = Optional.< Regions >of(regions);
        doNothing().when(this.regionsRepository).delete((Regions) any());
        when(this.regionsRepository.findById((Long) any())).thenReturn(ofResult);
        this.regionsService.delete(123L);
        verify(this.regionsRepository).delete((Regions) any());
        verify(this.regionsRepository).findById((Long) any());
    }

    @Test
    public void testDelete2() {
        doNothing().when(this.regionsRepository).delete((Regions) any());
        when(this.regionsRepository.findById((Long) any())).thenReturn(Optional.< Regions >empty());
        assertThrows(RegionsNotFoundException.class, () -> this.regionsService.delete(123L));
        verify(this.regionsRepository).findById((Long) any());
    }

    @Test
    public void testUpdate() {
        Regions regions = new Regions();
        regions.setRegionId(123L);
        regions.setRegionName("us-east-2");
        Optional< Regions > ofResult = Optional.< Regions >of(regions);

        Regions regions1 = new Regions();
        regions1.setRegionId(123L);
        regions1.setRegionName("us-east-2");
        when(this.regionsRepository.save((Regions) any())).thenReturn(regions1);
        when(this.regionsRepository.findById((Long) any())).thenReturn(ofResult);
        RegionsDto regionsDto = new RegionsDto();
        when(this.regionsMapper.toDto((Regions) any())).thenReturn(regionsDto);
        doNothing().when(this.regionsMapper).updateEntity((RegionsDto) any(), (Regions) any());
        assertSame(regionsDto, this.regionsService.update(new RegionsDto(), 123L));
        verify(this.regionsMapper).toDto((Regions) any());
        verify(this.regionsMapper).updateEntity((RegionsDto) any(), (Regions) any());
        verify(this.regionsRepository).save((Regions) any());
        verify(this.regionsRepository).findById((Long) any());
    }

    @Test
    public void testUpdate2() {
        Regions regions = new Regions();
        regions.setRegionId(123L);
        regions.setRegionName("us-east-2");
        when(this.regionsRepository.save((Regions) any())).thenReturn(regions);
        when(this.regionsRepository.findById((Long) any())).thenReturn(Optional.< Regions >empty());
        when(this.regionsMapper.toDto((Regions) any())).thenReturn(new RegionsDto());
        doNothing().when(this.regionsMapper).updateEntity((RegionsDto) any(), (Regions) any());
        assertThrows(RegionsNotFoundException.class, () -> this.regionsService.update(new RegionsDto(), 123L));
        verify(this.regionsRepository).findById((Long) any());
    }
}

