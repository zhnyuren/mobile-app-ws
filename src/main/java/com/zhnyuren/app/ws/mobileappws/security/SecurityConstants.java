package com.zhnyuren.app.ws.mobileappws.security;

import com.zhnyuren.app.ws.mobileappws.SpringApplicationContext;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 864000000; // 10 days

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_AUTHORIZATION = "Authorization";

    public static final String SIGN_UP_URL = "/users";

    public static final String USER_ID = "UserID";

    public static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("appProperties");
        return appProperties.getTokenSecret();
    }

}
