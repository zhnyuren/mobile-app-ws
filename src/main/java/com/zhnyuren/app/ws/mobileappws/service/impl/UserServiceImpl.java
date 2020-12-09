package com.zhnyuren.app.ws.mobileappws.service.impl;

import com.zhnyuren.app.ws.mobileappws.UserRepository;
import com.zhnyuren.app.ws.mobileappws.io.entity.UserEntity;
import com.zhnyuren.app.ws.mobileappws.service.UserService;
import com.zhnyuren.app.ws.mobileappws.shared.dto.UserDto;
import com.zhnyuren.app.ws.mobileappws.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final int USER_ID_LENGTH = 30;

    private final UserRepository userRepository;

    private final Utils utils;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository,
                           final Utils utils) {
        this.userRepository = userRepository;
        this.utils = utils;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if (null != userRepository.findByEmail(userDto.getEmail())) {
            throw new RuntimeException("Record already exists");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId(utils.generateUserId(USER_ID_LENGTH));

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
