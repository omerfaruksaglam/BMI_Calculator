/**
 * @author Ömer Faruk Sağlam
 * @date 12.05.2023
 * @description This class is the entry point of the Spring Boot application, which initializes and starts the Spring application context.
 */
package com.example.bmi_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BmiAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmiAppApplication.class, args);
    }

}
