package com.smsoft.carbe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CarBeApplication {
    private static final Logger logger = LoggerFactory.getLogger(CarBeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CarBeApplication.class, args);
        logger.info("Application Started");
    }

}
