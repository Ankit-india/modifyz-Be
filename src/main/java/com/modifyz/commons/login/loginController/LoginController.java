package com.modifyz.commons.login.loginController;

import com.modifyz.commons.login.service.LoginService;
import com.modifyz.commons.twilio.dto.NotificationRequestDto;
import org.hibernate.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> login(@RequestParam String phoneNumber, @RequestParam String gender) {
        try{
            loginService.login(phoneNumber, gender);
            System.out.println("Successfully logged in");
            return new ResponseEntity<>("Successfully logged In", HttpStatus.OK);
        }
        catch (Exception e){
            throw new CacheException("UnSuccessful" + e.getMessage());
        }
    }

    @PostMapping("/validateOtp")
    public ResponseEntity<String> verifyOtp(
        @RequestBody NotificationRequestDto notificationRequestDto) {
        String response = loginService.validateUser(notificationRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}