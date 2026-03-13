package com.jstudy.kafkaConsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test", groupId = "test-group", containerFactory = "testKafkaConsumerContainerFactory")
    public void listenTest(String message, Acknowledgment ack) {

        try {
            log.info("수신 메시지 = {}", message);
            //로직 추가해도 됨
            ack.acknowledge();
        } catch (Exception e) {
            log.error("메시지 수신을 실패하였습니다.");
            log.error("error message = {}", e.getMessage());
        }

    }

}
