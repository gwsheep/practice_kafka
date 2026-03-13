package com.jstudy.kafkaConsumer.schedule;


import com.jstudy.kafkaConsumer.dto.KafkaRequest;
import com.jstudy.kafkaConsumer.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class KafkaScheduler {

    private final KafkaService kafkaService;

    @Scheduled(fixedRate = 60000)
    public void sendSignalToCreateMsg() {

        KafkaRequest request = KafkaRequest.of("test", "Kafka Test", "Kafka 테스트 중입니다");
        kafkaService.publishMessage(request);

    }





}
