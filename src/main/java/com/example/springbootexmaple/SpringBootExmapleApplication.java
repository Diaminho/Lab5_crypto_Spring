package com.example.springbootexmaple;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootExmapleApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringBootExmapleApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootExmapleApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }
}
