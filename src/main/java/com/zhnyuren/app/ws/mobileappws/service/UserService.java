package com.zhnyuren.app.ws.mobileappws.service;

import com.zhnyuren.app.ws.mobileappws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);

    UserDto getUser(final String email);

}
