package com.modifyz.usersDetails.controller;

import com.modifyz.usersDetails.dto.UserDto;
import com.modifyz.usersDetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

   @Autowired UserService userService;

    @PostMapping("/")
    public UserDto createUser(UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return savedUser;
    }
}
