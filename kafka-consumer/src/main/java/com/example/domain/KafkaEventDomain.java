package com.example.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KafkaEventDomain {
    private String name;
    private LocalDateTime publishedTime;
}
