package com.modifyz.commons.login.service.impl;

import com.modifyz.commons.login.service.LoginService;
import com.modifyz.commons.twilio.constants.NotificationStatus;
import com.modifyz.commons.twilio.dto.NotificationRequestDto;
import com.modifyz.commons.twilio.dto.NotificationResponseDto;
import com.modifyz.commons.twilio.notificationService.NotificationService;
import com.modifyz.usersDetails.domain.User;
import com.modifyz.usersDetails.dto.UserDto;
import com.modifyz.usersDetails.repository.UserRepository;
import com.modifyz.usersDetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired NotificationService notificationService;

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public NotificationResponseDto login(String phoneNumber) {
        // TODO : fetch user location from Google API
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if(user == null) {
            userService.createUser(
                UserDto.Builder.userDto()
                    .withName(null)
                    .withPhoneNumber(phoneNumber)
                    .withLocation(null)
                    .build()
            );
        }

        return notificationService.sendOtp(phoneNumber);
    }

    @Override
    public String validateUser(NotificationRequestDto notificationRequestDto) {
        String response = notificationService.validateOtp(notificationRequestDto);
        if(response.equals(NotificationStatus.VERIFIED.getDisplayName())) {
            User user = userRepository.findByPhoneNumber(notificationRequestDto.getPhoneNumber());
            user.setLoggedIn(true);
            userRepository.save(user);
        }
        return response;
    }
}
