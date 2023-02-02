package com.example.kafkaproducer.controller;

import com.example.domain.KafkaEventDomain;
import com.example.kafkaproducer.service.EventProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping(path = "/event-produces", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventProduceController {

    private final EventProducerService eventProducerService;

    public EventProduceController(EventProducerService eventProducerService) {
        this.eventProducerService = eventProducerService;
    }

    @GetMapping
    public ResponseEntity<String> eventProduce() {
        eventProducerService.publishEvent(new KafkaEventDomain("Kafka producer", LocalDateTime.now()));
        return ResponseEntity.ok("Event published. At time: " + LocalDateTime.now());
    }
}
