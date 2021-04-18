package com.stef.rh.controller;

import com.stef.rh.api.RegionsApi;
import com.stef.rh.models.RegionsDto;
import com.stef.rh.service.IRegionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class RegionsController implements RegionsApi {
    private final IRegionsService regionsService;
    @Override
    public ResponseEntity< List< RegionsDto > > getAllRegions() {
        return new ResponseEntity<>(regionsService.getAllRegions(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity< RegionsDto> getRegionsById(Long id) {
        final RegionsDto regionsById = regionsService.getRegionsById(id);
        if(Objects.nonNull(regionsById)){
            return new ResponseEntity<>(regionsById,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
