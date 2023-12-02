package com.modifyz.services;

import com.modifyz.dto.FacilityDto;
import java.util.List;

public interface FacilityService {

    FacilityDto createFacility(FacilityDto facilityDto);

    FacilityDto updateFacility(String shopId, String facilityId,FacilityDto facilityDto);

    List<FacilityDto> getFacilityByShopId(String shopId);

    FacilityDto getFacilityByShopIdAndServiceName(String shopId, String serviceName);
}
