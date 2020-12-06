package com.zhnyuren.app.ws.mobileappws.shared.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {

    private static final long serialVersionUID = 6232169966728470018L;

    private long id;

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String encryptedPassword;

    private String emailVerificationToken;

    private Boolean emailVerificationStatus;
}

