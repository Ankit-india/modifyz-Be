package com.modifyz.services.impl;

import com.modifyz.convertor.TimeDetailsConvertor;
import com.modifyz.dto.TimeDetailsDto;
import com.modifyz.entities.TimeDetails;
import com.modifyz.repositories.TimeDetailsRepository;
import com.modifyz.services.TimeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class TimeDetailsServiceImpl implements TimeDetailsService {

    @Autowired TimeDetailsConvertor timeDetailsConvertor;

    @Autowired TimeDetailsRepository timeDetailsRepository;

    @Override
    public TimeDetails addTimeDetails(TimeDetailsDto timeDetailsDto) {
        TimeDetails timeDetails = timeDetailsConvertor.convert(timeDetailsDto);

        timeDetails = timeDetailsRepository.save(timeDetails);

        return timeDetails;
    }
}
