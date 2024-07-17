package com.example.demo.config.env;

import net.bytebuddy.asm.Advice.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
public class LocalConfiguration implements EnvConfiguration {

    private final Logger LOGGER = LoggerFactory.getLogger(LocalConfiguration.class);

    @Value("## dev 환경")
    private String messagae;

    @Override
    @Bean
    public String getMessage() {
        LOGGER.info("[getMessage] localConfiguration");
        return messagae;
    }
}
