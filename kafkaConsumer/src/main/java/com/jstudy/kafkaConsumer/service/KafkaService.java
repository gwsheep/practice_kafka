package com.jstudy.kafkaConsumer.service;

import com.jstudy.kafkaConsumer.dto.KafkaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public String publishMessage(KafkaRequest request) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowTime = now.format(formatter);

        String parsedMsg = "["+ nowTime + "]" + " Title : " + request.getTestTitle() + ", Content : " + request.getTestMessage();

        try {
            kafkaTemplate.send(request.getTopic(), parsedMsg);
            return "success";
        } catch (Exception e) {
            log.error("error msg = {}", e.getMessage());
            return "fail";
        }

    }


}
