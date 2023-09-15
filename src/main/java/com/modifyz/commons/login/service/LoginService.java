package com.modifyz.commons.login.service;

import com.modifyz.commons.twilio.dto.NotificationRequestDto;
import com.modifyz.commons.twilio.dto.NotificationResponseDto;

public interface LoginService {

    NotificationResponseDto login(String phoneNumber);

    String validateUser(NotificationRequestDto notificationRequestDto);
}
