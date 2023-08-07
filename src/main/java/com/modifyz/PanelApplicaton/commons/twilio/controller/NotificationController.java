package com.modifyz.PanelApplicaton.commons.twilio.controller;

import com.modifyz.PanelApplicaton.commons.twilio.dto.NotificationRequestDto;
import com.modifyz.PanelApplicaton.commons.twilio.dto.NotificationResponseDto;
import com.modifyz.PanelApplicaton.commons.twilio.notificationService.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/otp")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/sendSmsNotification")
    public ResponseEntity<NotificationResponseDto> generateOtp(@RequestBody
    NotificationRequestDto notificationRequestDto) {
        NotificationResponseDto notificationResponseDto = notificationService.sendSmsNotification(notificationRequestDto);
        return  new ResponseEntity<>(notificationResponseDto, HttpStatus.OK);
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<String> verifyOtp(@RequestBody NotificationRequestDto notificationRequestDto) {
        String response = notificationService.validateOtp(notificationRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}