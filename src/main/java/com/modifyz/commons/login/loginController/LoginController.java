package com.modifyz.commons.login.loginController;

import com.modifyz.commons.common.ApiResponse;
import com.modifyz.commons.login.service.LoginService;
import com.modifyz.commons.twilio.dto.NotificationRequestDto;
import com.modifyz.commons.twilio.dto.NotificationResponseDto;
import org.hibernate.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired LoginService loginService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse<NotificationResponseDto>> login(@RequestParam String phoneNumber, @RequestParam String gender) {
        try{
            NotificationResponseDto notificationResponseDto = loginService.login(phoneNumber, gender);
            System.out.println("Successfully logged in");
            return ResponseEntity.ok(
                ApiResponse.success("Successfully logged in", notificationResponseDto));
        }
        catch (Exception e){
            throw new CacheException("UnSuccessful" + e.getMessage());
        }
    }

    @PostMapping("/validateOtp")
    public ResponseEntity<ApiResponse<String>> verifyOtp(
        @RequestBody NotificationRequestDto notificationRequestDto) {
        String response = loginService.validateUser(notificationRequestDto);
        return ResponseEntity.ok(
            ApiResponse.success("Successfully validate the user", response));
    }
}