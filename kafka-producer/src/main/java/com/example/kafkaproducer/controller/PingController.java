package com.example.kafkaproducer.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
public class PingController {

    private final HttpServletRequest request;

    public PingController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping
    public ResponseEntity<?> ping() {
        Map<String, Object> pingResponse = new HashMap<>();

        pingResponse.put("RequestFrom", request.getRemoteHost());
        pingResponse.put("RequestUser", request.getRemoteUser());
        pingResponse.put("Time", LocalDateTime.now());
        pingResponse.put("Service", "Kafka Producer");
        log.info("Producer service alive...");
        return ResponseEntity.ok(pingResponse);
    }
}
