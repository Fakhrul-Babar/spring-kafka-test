package com.example.kafkaconsumer.service;

import com.example.domain.KafkaEventDomain;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaEventListener {

    @KafkaListener(
            topics = {"kafka-test"}
    )
    public void onStatusEvent(ConsumerRecord<String, Object> consumerRecord) {
        KafkaEventDomain event = (KafkaEventDomain) consumerRecord.value();
        log.info("Consumer Record: " + consumerRecord);
        log.info("Consumed object: " + event.toString());
        log.info("kafka event consumed from publisher");
    }
}
