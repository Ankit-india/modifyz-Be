package com.modifyz.commons.twilio.convertor;

import com.modifyz.commons.twilio.constants.NotificationStatus;
import com.modifyz.commons.twilio.dto.NotificationResponseDto;
import org.springframework.stereotype.Component;

@Component
public class NotificationConvertor {

    public NotificationResponseDto convert(NotificationStatus notificationStatus, String message, String otp) {
        NotificationResponseDto notificationResponseDto =
            NotificationResponseDto.Builder.notificationResponseDto()
                .withNotificationStatus(notificationStatus)
                .withMessage(message)
                .withOtp(otp)
                .build();

        return notificationResponseDto;
    }
}
