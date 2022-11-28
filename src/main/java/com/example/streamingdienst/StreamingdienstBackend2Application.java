package com.example.streamingdienst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class StreamingdienstBackend2Application {

    public static void main(String[] args) {
        SpringApplication.run(StreamingdienstBackend2Application.class, args);
    }

}
