package com.incentives.piggyback.events;

import java.io.IOException;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class EventsApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(EventsApplication.class, args);
    }

}