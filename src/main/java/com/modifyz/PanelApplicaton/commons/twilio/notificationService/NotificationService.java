package com.modifyz.PanelApplicaton.commons.twilio.notificationService;

import com.modifyz.PanelApplicaton.commons.twilio.dto.NotificationRequestDto;
import com.modifyz.PanelApplicaton.commons.twilio.dto.NotificationResponseDto;

public interface NotificationService {
    NotificationResponseDto sendSmsNotification(NotificationRequestDto notificationRequestDto);

    String validateOtp(NotificationRequestDto notificationRequestDto);
}
