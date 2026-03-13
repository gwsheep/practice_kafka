package com.jstudy.kafkaConsumer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KafkaRequest {

    private String topic;

    private String testTitle;

    private String testMessage;

    public static KafkaRequest of (String topic, String testTitle, String testMessage) {
        KafkaRequest request = new KafkaRequest();
        request.topic = topic;
        request.testTitle = testTitle;
        request.testMessage = testMessage;
        return request;
    }


}
