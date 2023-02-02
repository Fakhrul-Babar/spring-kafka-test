package com.example.kafkaproducer.service;

import com.example.domain.KafkaEventDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class EventProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEvent(KafkaEventDomain event) {
        log.info("Kafka event published on time: " + LocalDateTime.now());
        kafkaTemplate.send("kafka-test", event);

//        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//
//            @Override
//            public void onSuccess(SendResult<String, String> result) {
//                System.out.println("Sent message=[" + event +
//                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            }
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("Unable to send message=["
//                        + event + "] due to : " + ex.getMessage());
//            }
//        });
    }

}
