package com.modifyz.convertor;

import com.modifyz.entities.User;
import com.modifyz.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convert(UserDto userDto) {
        return User.Builder.user()
            .withName(userDto.getName())
            .withPhoneNumber(userDto.getPhoneNumber())
            .withLocation(userDto.getLocation())
            .withGender(userDto.getGender())
            .withIsLoggedIn(false)
            .build();
    }

    public UserDto convertDto(User user) {
        return UserDto.Builder.userDto()
            .withName(user.getName())
            .withPhoneNumber(user.getPhoneNumber())
            .withLocation(user.getLocation())
            .withGender(user.getGender())
            .build();
    }
}
