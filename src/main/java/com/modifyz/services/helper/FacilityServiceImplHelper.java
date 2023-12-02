package com.modifyz.services.helper;

import com.modifyz.dto.FacilityDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FacilityServiceImplHelper {

    public Boolean isUniqueFacility(List<FacilityDto> facilityList, String facilityName) {
        for (FacilityDto facilityDto: facilityList) {
            if(facilityDto.getServiceName().equals(facilityName)) {
                return false;
            }
        }
        return true;
    }
}
