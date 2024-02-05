package com.sign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.sign")
public class SignInApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignInApplication.class, args);
    }

}
