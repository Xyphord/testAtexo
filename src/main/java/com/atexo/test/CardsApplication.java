package com.atexo.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardsApplication {

    private static final Logger log = LogManager.getLogger(CardsApplication.class);

    public static void main(String[] args) {

        log.error("error");
        log.info("info");
        log.debug("debug");
        log.warn("warn");

        SpringApplication.run(CardsApplication.class, args);
    }

}