package com.modifyz.usersDetails.service.impl;

import com.modifyz.usersDetails.convertor.UserConverter;
import com.modifyz.usersDetails.domain.User;
import com.modifyz.usersDetails.dto.UserDto;
import com.modifyz.usersDetails.repository.UserRepository;
import com.modifyz.usersDetails.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired UserConverter userConverter;

    @Autowired UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userConverter.convert(userDto);
        userRepository.save(user);
        UserDto savedUser = userConverter.convertDto(user);
        return savedUser;
    }
}
