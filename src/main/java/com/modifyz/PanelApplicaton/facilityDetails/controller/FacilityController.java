package com.modifyz.PanelApplicaton.facilityDetails.controller;

import com.modifyz.PanelApplicaton.facilityDetails.dto.FacilityDto;
import com.modifyz.PanelApplicaton.facilityDetails.service.FacilityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/service")
public class FacilityController {

    @Autowired FacilityService facilityService;

    @PostMapping("/")
    public ResponseEntity<FacilityDto> createFacility(@RequestBody FacilityDto facilityDto) {
        FacilityDto facility = facilityService.createFacility(facilityDto);
        return new ResponseEntity<>(facility, HttpStatus.CREATED);
    }

    @PutMapping("/updateFacility")
    public ResponseEntity<FacilityDto> updateFacility(@RequestParam String shopId,
        @RequestParam String facilityId, @RequestBody FacilityDto facilityDto) {
        FacilityDto facility = facilityService.updateFacility(shopId, facilityId, facilityDto);
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }

    @GetMapping("/shop/{shopId}/getFacility/")
    public ResponseEntity<List<FacilityDto>> getFacilityByShopId(@PathVariable String shopId) {
        List<FacilityDto> facilitiesList = facilityService.getFacilityByShopId(shopId);
        return new ResponseEntity<>(facilitiesList, HttpStatus.OK);
    }

    @GetMapping("/{shopId}/getFacility/")
    public ResponseEntity<FacilityDto> getFacilityByServiceName(@PathVariable String shopId,
        @RequestParam String serviceName) {
        FacilityDto facility =
            facilityService.getFacilityByShopIdAndServiceName(shopId, serviceName);
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }
}
