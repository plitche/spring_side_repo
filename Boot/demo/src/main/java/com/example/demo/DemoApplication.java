package com.example.demo;

import com.example.demo.config.ProfileManager;
import com.example.demo.config.env.EnvConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// @EnableJpaAuditing
public class DemoApplication {

	@Autowired
	public DemoApplication(EnvConfiguration envConfiguration, ProfileManager profileManager) {
		profileManager.printActiveProfiles();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
