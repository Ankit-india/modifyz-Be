package com.modifyz.PanelApplicaton.facilityDetails.service;

import com.modifyz.PanelApplicaton.facilityDetails.domain.Facility;
import com.modifyz.PanelApplicaton.facilityDetails.dto.FacilityDto;

public interface FacilityService {

    Facility createOrUpdate(FacilityDto facilityDto);
}
