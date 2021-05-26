package com.stef.rh.controller;

import com.stef.rh.api.RegionsApi;
import com.stef.rh.dto.RegionsDto;
import com.stef.rh.service.IRegionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RegionsController implements RegionsApi {
    private final IRegionsService regionsService;

    @Override
    public ResponseEntity< RegionsDto > addRegions(RegionsDto body) {
        return new ResponseEntity<>(regionsService.save(body),HttpStatus.OK);
    }

    @Override
    public ResponseEntity< Void > deleteRegionsById(Long id) {
        regionsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity< List< RegionsDto > > getAllRegions() {
        return new ResponseEntity<>(regionsService.getAllRegions(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity< RegionsDto> getRegionsById(Long id) {
            return new ResponseEntity<>(regionsService.getRegionsById(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity< RegionsDto > updateRegions(RegionsDto body, Long id) {
        return new ResponseEntity<>(regionsService.update(body, id), HttpStatus.OK);
    }
}
