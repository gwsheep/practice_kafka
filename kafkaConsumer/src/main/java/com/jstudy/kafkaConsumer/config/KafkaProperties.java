package com.jstudy.kafkaConsumer.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@ToString
@ConfigurationProperties(prefix = "spring.kafka")
@Getter
@Setter
public class KafkaProperties {

    private List<String> bootstrapServers;
    private Consumer consumer;

    @Data
    public static class Consumer {

        private String groupId;
        private String autoOffsetReset;
        private Boolean enableAutoCommit;
        private String keyDeserializer;
        private String valueDeserializer;
        private Integer maxPollRecords;

    }

}
