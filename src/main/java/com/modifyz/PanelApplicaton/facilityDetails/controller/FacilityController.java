package com.modifyz.PanelApplicaton.facilityDetails.controller;

import com.modifyz.PanelApplicaton.facilityDetails.domain.Facility;
import com.modifyz.PanelApplicaton.facilityDetails.dto.FacilityDto;
import com.modifyz.PanelApplicaton.facilityDetails.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/service")
public class FacilityController {

    @Autowired FacilityService facilityService;

    @RequestMapping("/")
    public ResponseEntity<Facility> createOrUpdateService(FacilityDto facilityDto) {
        Facility facility = facilityService.createOrUpdate(facilityDto);
        return new ResponseEntity<>(facility, HttpStatus.CREATED);
    }
}
