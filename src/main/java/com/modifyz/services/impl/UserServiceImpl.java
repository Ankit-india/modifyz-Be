package com.modifyz.services.impl;

import com.modifyz.convertor.UserConverter;
import com.modifyz.entities.User;
import com.modifyz.dto.UserDto;
import com.modifyz.repositories.UserRepository;
import com.modifyz.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
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
