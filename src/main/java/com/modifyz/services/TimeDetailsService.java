package com.modifyz.services;

import com.modifyz.dto.TimeDetailsDto;
import com.modifyz.entities.TimeDetails;

public interface TimeDetailsService {

    TimeDetails addTimeDetails(TimeDetailsDto timeDetailsDto);
}
