package com.modifyz.PanelApplicaton.facilityDetails.convertor;

import com.modifyz.PanelApplicaton.facilityDetails.domain.Facility;
import com.modifyz.PanelApplicaton.facilityDetails.dto.FacilityDto;
import org.springframework.stereotype.Component;

@Component
public class FacilityConvertor {

    public Facility convert(FacilityDto facilityDto) {
        Facility facility = Facility.Builder.facility()
            .withShopId(facilityDto.getShopId())
            .withServiceName(facilityDto.getServiceName())
            .withImage(facilityDto.getImage())
            .withPrice(facilityDto.getPrice())
            .withEstimatedTime(facilityDto.getEstimatedTime())
            .withTimeUnit(facilityDto.getTimeUnit())
            .build();

        return facility;
    }
}
