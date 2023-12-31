package com.modifyz.convertor;

import com.modifyz.entities.Facility;
import com.modifyz.dto.FacilityDto;
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

    public FacilityDto convertDto(Facility facility) {
        FacilityDto facilityDto = FacilityDto.Builder.facilityDto()
            .withShopId(facility.getShopId())
            .withServiceName(facility.getServiceName())
            .withImage(facility.getImage())
            .withPrice(facility.getPrice())
            .withEstimatedTime(facility.getEstimatedTime())
            .withTimeUnit(facility.getTimeUnit())
            .build();
        return facilityDto;
    }
}