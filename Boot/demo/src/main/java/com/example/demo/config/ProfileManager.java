package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProfileManager {

    private final Logger LOGGER = LoggerFactory.getLogger(ProfileManager.class);
    private final Environment environment;

    @Autowired
    public ProfileManager(Environment environment) {
        this.environment = environment;
    }

    public void printActiveProfiles() {
        LOGGER.info("[printActiveProfiles] active Profiles size : {}", environment.getActiveProfiles().length);
        for (String activeProfile : environment.getActiveProfiles()) {
            LOGGER.info("[printActiveProfiles] profiles : {}", activeProfile);
        }
    }


}
