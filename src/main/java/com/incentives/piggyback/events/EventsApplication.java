package com.incentives.piggyback.events;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventsApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(EventsApplication.class, args);
    }

}