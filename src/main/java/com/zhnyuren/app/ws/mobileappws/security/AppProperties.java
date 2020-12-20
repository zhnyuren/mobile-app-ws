package com.zhnyuren.app.ws.mobileappws.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    final private Environment environment;

    @Autowired
    public AppProperties(final Environment environment) {
        this.environment = environment;
    }

    public String getTokenSecret() {
        return environment.getProperty("tokenSecret");
    }

}
