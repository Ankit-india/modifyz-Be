package com.modifyz.commons.twilio.notificationService;

import com.modifyz.commons.twilio.dto.NotificationRequestDto;
import com.modifyz.commons.twilio.dto.NotificationResponseDto;

public interface NotificationService {
    NotificationResponseDto sendOtp(String phoneNumber);

    String validateOtp(NotificationRequestDto notificationRequestDto);
}
