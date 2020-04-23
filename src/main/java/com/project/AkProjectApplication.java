package com.project;

import com.project.controllers.LinkController;
import com.project.services.LinkDtoService;
import com.project.services.LinkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication //(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@ComponentScan(value = {
        "com.project.controllers",
        "com.project.exceptions",
        "com.project.mapper",
        "com.project.models",
        "com.project.models.dtos",
        "com.project.services",
        "com.project.repositories",
        "com.project.security",
        "com.project.security.models",
        "com.project.security.repos",
        "com.project.docs",
        "com.project.controllers.rest",
        "com.project.commons",
        "com.project.email"
        })
public class AkProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AkProjectApplication.class, args);
    }

    @Bean
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
