package com.modifyz.usersDetails.convertor;

import com.modifyz.usersDetails.domain.User;
import com.modifyz.usersDetails.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convert(UserDto userDto) {
        return User.Builder.user()
            .withName(userDto.getName())
            .withPhoneNumber(userDto.getPhoneNumber())
            .withLocation(userDto.getLocation())
            .withIsLoggedIn(false)
            .build();
    }

    public UserDto convertDto(User user) {
        return UserDto.Builder.userDto()
            .withName(user.getName())
            .withPhoneNumber(user.getPhoneNumber())
            .withLocation(user.getLocation())
            .build();
    }
}
