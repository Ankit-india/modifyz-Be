package com.modifyz.convertor;

import com.modifyz.constant.Meridiem;
import com.modifyz.dto.TimeDetailsDto;
import com.modifyz.entities.TimeDetails;
import org.springframework.stereotype.Component;

@Component
public class TimeDetailsConvertor {

    public TimeDetails convert(TimeDetailsDto timeDetailsDto, String shopId) {
        return TimeDetails.Builder.timeDetails()
            .withShopId(shopId)
            .withStartTime(TimeDetails.Time.Builder.time()
                .withHours(timeDetailsDto.getStartTime().getHours())
                .withMinutes(timeDetailsDto.getStartTime().getMinutes())
                .withMeridiem(Meridiem.valueOf(timeDetailsDto.getStartTime().getMeridiem()))
                .build())
            .withEndTime(TimeDetails.Time.Builder.time()
                .withHours(timeDetailsDto.getEndTime().getHours())
                .withMinutes(timeDetailsDto.getEndTime().getMinutes())
                .withMeridiem(Meridiem.valueOf(timeDetailsDto.getEndTime().getMeridiem()))
                .build())
            .build();
    }

    public TimeDetails convert(TimeDetailsDto timeDetailsDto) {
        return TimeDetails.Builder.timeDetails()
            .withShopId(null)
            .withStartTime(TimeDetails.Time.Builder.time()
                .withHours(timeDetailsDto.getStartTime().getHours())
                .withMinutes(timeDetailsDto.getStartTime().getMinutes())
                .withMeridiem(Meridiem.valueOf(timeDetailsDto.getStartTime().getMeridiem()))
                .build()
            )
            .withEndTime(TimeDetails.Time.Builder.time()
                .withHours(timeDetailsDto.getEndTime().getHours())
                .withMinutes(timeDetailsDto.getEndTime().getMinutes())
                .withMeridiem(Meridiem.valueOf(timeDetailsDto.getEndTime().getMeridiem()))
                .build())
            .build();
    }
}
