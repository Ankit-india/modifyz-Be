package com.modifyz.PanelApplicaton.facilityDetails.service;

import com.modifyz.PanelApplicaton.facilityDetails.domain.Facility;
import com.modifyz.PanelApplicaton.facilityDetails.dto.FacilityDto;
import java.util.List;

public interface FacilityService {

    FacilityDto createFacility(FacilityDto facilityDto);

    FacilityDto updateFacility(String shopId, String facilityId,FacilityDto facilityDto);

    List<FacilityDto> getFacilityByShopId(String shopId);

    FacilityDto getFacilityByShopIdAndServiceName(String shopId, String serviceName);
}
