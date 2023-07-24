package com.modifyz.PanelApplicaton.facilityDetails.service.impl;

import com.modifyz.PanelApplicaton.facilityDetails.convertor.FacilityConvertor;
import com.modifyz.PanelApplicaton.facilityDetails.domain.Facility;
import com.modifyz.PanelApplicaton.facilityDetails.dto.FacilityDto;
import com.modifyz.PanelApplicaton.facilityDetails.repository.FacilityRepository;
import com.modifyz.PanelApplicaton.facilityDetails.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired FacilityRepository facilityRepository;

    @Autowired FacilityConvertor facilityConvertor;

    public Facility createOrUpdate(FacilityDto facilityDto) {
        Facility facility = facilityConvertor.convert(facilityDto);
        facilityRepository.save(facility);
        return facility;
    }
}
