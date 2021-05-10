package com.stef.rh.controller;

import com.stef.rh.exception.RegionsNotFoundException;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {RegionsController.class})
@ExtendWith(SpringExtension.class)
class RegionsControllerTest {
    @MockBean
    private IRegionsService iRegionsService;

    @Autowired
    private RegionsController regionsController;

    @Test
    void testAddRegions() {
        when(this.iRegionsService.save(any(RegionsDto.class))).thenThrow(new RegionsNotFoundException(12l));
        assertThatThrownBy(() -> this.regionsController.addRegions(new RegionsDto()))
                .isInstanceOf(RegionsNotFoundException.class)
                .hasMessage("la région avec l'ID 12 est introuvable");

    }

    @Test
    void testAddNullRegions() {
        when(this.iRegionsService.save(any(RegionsDto.class))).thenReturn(null);
        ResponseEntity< RegionsDto > actualAddRegionsResult = this.regionsController.addRegions(new RegionsDto());
        assertThat(actualAddRegionsResult.toString()).hasToString("<200 OK OK,[]>");
        assertThat(actualAddRegionsResult.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualAddRegionsResult.hasBody()).isFalse();
        verify(this.iRegionsService).save(any(RegionsDto.class));
    }

    @Test
    void testDeleteRegionsById() {
        doNothing().when(this.iRegionsService).delete(anyLong());
        ResponseEntity< Void > actualDeleteRegionsByIdResult = this.regionsController.deleteRegionsById(123L);
        assertThat(actualDeleteRegionsByIdResult.getBody()).isNull();
        assertThat(actualDeleteRegionsByIdResult.toString()).hasToString("<200 OK OK,[]>");
        assertThat(actualDeleteRegionsByIdResult.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(this.iRegionsService).delete(anyLong());
    }

    @Test
    void testGetAllRegions() {
        when(this.iRegionsService.getAllRegions()).thenReturn(new ArrayList< RegionsDto >());
        ResponseEntity< List< RegionsDto > > actualAllRegions = this.regionsController.getAllRegions();
        assertThat(actualAllRegions.toString()).hasToString("<200 OK OK,[],[]>");
        assertThat(actualAllRegions.hasBody()).isTrue();
        assertThat(actualAllRegions.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(this.iRegionsService).getAllRegions();
    }

    @Test
    void testGetRegionsById() {
        when(this.iRegionsService.getRegionsById(anyLong())).thenReturn(new RegionsDto());
        ResponseEntity< RegionsDto > actualRegionsById = this.regionsController.getRegionsById(123L);
        assertThat(actualRegionsById.toString()).hasToString("<200 OK OK,class RegionsDto {\n    id: null\n    regionName: null\n},[]>");
        assertThat(actualRegionsById.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualRegionsById.hasBody()).isTrue();
        verify(this.iRegionsService).getRegionsById(anyLong());
    }

    @Test
    void testUpdateRegions() {
        when(this.iRegionsService.update(any(RegionsDto.class), anyLong())).thenReturn(new RegionsDto());
        ResponseEntity< RegionsDto > actualUpdateRegionsResult = this.regionsController.updateRegions(new RegionsDto(), 123L);
        assertThat(actualUpdateRegionsResult.toString()).hasToString("<200 OK OK,class RegionsDto {\n    id: null\n    regionName: null\n},[]>");
        assertThat(actualUpdateRegionsResult.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualUpdateRegionsResult.hasBody()).isTrue();
        verify(this.iRegionsService).update(any(RegionsDto.class), anyLong());
    }
}

