package com.modifyz.commons.login.service;

import com.modifyz.commons.twilio.dto.NotificationRequestDto;
import com.modifyz.commons.twilio.dto.NotificationResponseDto;

public interface LoginService {

    NotificationResponseDto login(String phoneNumber, String Gender);

    String validateUser(NotificationRequestDto notificationRequestDto);
}
