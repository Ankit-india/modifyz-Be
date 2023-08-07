package com.modifyz.PanelApplicaton.commons.twilio.convertor;

import com.modifyz.PanelApplicaton.commons.twilio.constants.NotificationStatus;
import com.modifyz.PanelApplicaton.commons.twilio.dto.NotificationResponseDto;
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
