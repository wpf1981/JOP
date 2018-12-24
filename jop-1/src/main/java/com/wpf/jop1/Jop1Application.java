package com.wpf.jop1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Jop1Application {

    public static void main(String[] args) {
        SpringApplication.run(Jop1Application.class, args);
    }

}

