package com.modifyz.PanelApplicaton.facilityDetails.service.impl;

import com.modifyz.PanelApplicaton.facilityDetails.convertor.FacilityConvertor;
import com.modifyz.PanelApplicaton.facilityDetails.domain.Facility;
import com.modifyz.PanelApplicaton.facilityDetails.dto.FacilityDto;
import com.modifyz.PanelApplicaton.facilityDetails.repository.FacilityRepository;
import com.modifyz.PanelApplicaton.facilityDetails.service.FacilityService;
import com.modifyz.PanelApplicaton.facilityDetails.service.helper.FacilityServiceImplHelper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired FacilityRepository facilityRepository;

    @Autowired FacilityConvertor facilityConvertor;

    @Autowired FacilityServiceImplHelper facilityServiceImplHelper;

    public FacilityDto createFacility(FacilityDto facilityDto) {

        List<FacilityDto> facilities = getFacilityByShopId(facilityDto.getShopId());
        Boolean uniqueServiceByNameCheck =
            facilityServiceImplHelper.isUniqueFacility(facilities, facilityDto.getServiceName());
        Facility facility = null;
        if (uniqueServiceByNameCheck) {
            facility = facilityConvertor.convert(facilityDto);
            facilityRepository.save(facility);
        } else {
            throw new RuntimeException(
                "Service ["
                    + facilityDto.getServiceName()
                    + "] already exist!! You Cannot Create Duplicate Service");
        }
        return facilityDto;
    }

    // TODO -- will be fixing this in next commit
    public FacilityDto updateFacility(String shopId, FacilityDto facilityDto) {
        Optional<Facility> facilityOptional = facilityRepository.findById(Long.parseLong(shopId));

        if (facilityOptional.isPresent()) {
            Facility facility = facilityOptional.get();

            facility.setServiceName(facilityDto.getServiceName());
            facility.setPrice(facilityDto.getPrice());
            facility.setImage(facilityDto.getImage());
            facility.setEstimatedTime(facilityDto.getEstimatedTime());
            facility.setTimeUnit(facilityDto.getTimeUnit());

            facility = facilityRepository.save(facility);

            FacilityDto updatedFacilityDto = facilityConvertor.convertDto(facility);
            return updatedFacilityDto;
        }
        else {
            throw new RuntimeException("Cannot Find the Facility");
        }
    }


    public List<FacilityDto> getFacilityByShopId(String shopId) {
        List<Facility> facilityList = facilityRepository.findFacilityByShopId(shopId);

        List<FacilityDto> facilityDtoList = facilityList.stream()
            .map(facility -> facilityConvertor.convertDto(facility))
            .collect(Collectors.toList());

        return facilityDtoList;
    }

    public FacilityDto getFacilityByShopIdAndServiceName(String shopId, String serviceName) {
        Facility facility =
            facilityRepository.getFacilityByShopIdAndServiceName(shopId, serviceName);
        FacilityDto facilityDto = facilityConvertor.convertDto(facility);
        return facilityDto;
    }
}
