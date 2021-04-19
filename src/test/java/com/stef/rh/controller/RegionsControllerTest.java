package com.stef.rh.controller;

import com.stef.rh.models.RegionsDto;
import com.stef.rh.service.IRegionsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {RegionsController.class})
@ExtendWith(SpringExtension.class)
public class RegionsControllerTest {
    @MockBean
    private IRegionsService iRegionsService;

    @Autowired
    private RegionsController regionsController;

    @Test
    public void testAddRegions() {
        when(this.iRegionsService.save((RegionsDto) any())).thenReturn(new RegionsDto());
        ResponseEntity< RegionsDto > actualAddRegionsResult = this.regionsController.addRegions(new RegionsDto());
        assertEquals("<200 OK OK,class RegionsDto {\n    id: null\n    regionName: null\n},[]>",
                actualAddRegionsResult.toString());
        assertEquals(HttpStatus.OK, actualAddRegionsResult.getStatusCode());
        assertTrue(actualAddRegionsResult.hasBody());
        verify(this.iRegionsService).save((RegionsDto) any());
    }

    @Test
    public void testDeleteRegionsById() {
        doNothing().when(this.iRegionsService).delete((Long) any());
        ResponseEntity< Void > actualDeleteRegionsByIdResult = this.regionsController.deleteRegionsById(123L);
        assertNull(actualDeleteRegionsByIdResult.getBody());
        assertEquals("<200 OK OK,[]>", actualDeleteRegionsByIdResult.toString());
        assertEquals(HttpStatus.OK, actualDeleteRegionsByIdResult.getStatusCode());
        verify(this.iRegionsService).delete((Long) any());
    }

    @Test
    public void testGetAllRegions() {
        when(this.iRegionsService.getAllRegions()).thenReturn(new ArrayList< RegionsDto >());
        ResponseEntity< List< RegionsDto > > actualAllRegions = this.regionsController.getAllRegions();
        assertEquals("<200 OK OK,[],[]>", actualAllRegions.toString());
        assertTrue(actualAllRegions.hasBody());
        assertEquals(HttpStatus.OK, actualAllRegions.getStatusCode());
        verify(this.iRegionsService).getAllRegions();
    }

    @Test
    public void testGetRegionsById() {
        when(this.iRegionsService.getRegionsById((Long) any())).thenReturn(new RegionsDto());
        ResponseEntity< RegionsDto > actualRegionsById = this.regionsController.getRegionsById(123L);
        assertEquals("<200 OK OK,class RegionsDto {\n    id: null\n    regionName: null\n},[]>",
                actualRegionsById.toString());
        assertEquals(HttpStatus.OK, actualRegionsById.getStatusCode());
        assertTrue(actualRegionsById.hasBody());
        verify(this.iRegionsService).getRegionsById((Long) any());
    }

    @Test
    public void testUpdateRegions() {
        when(this.iRegionsService.update((RegionsDto) any(), (Long) any())).thenReturn(new RegionsDto());
        ResponseEntity< RegionsDto > actualUpdateRegionsResult = this.regionsController.updateRegions(new RegionsDto(), 123L);
        assertEquals("<200 OK OK,class RegionsDto {\n    id: null\n    regionName: null\n},[]>",
                actualUpdateRegionsResult.toString());
        assertEquals(HttpStatus.OK, actualUpdateRegionsResult.getStatusCode());
        assertTrue(actualUpdateRegionsResult.hasBody());
        verify(this.iRegionsService).update((RegionsDto) any(), (Long) any());
    }
}

