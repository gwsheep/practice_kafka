package com.jstudy.kafkaConsumer.controller;


import com.jstudy.kafkaConsumer.dto.KafkaRequest;
import com.jstudy.kafkaConsumer.service.KafkaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaService kafkaService;

    @PostMapping("/publish")
    public ResponseEntity<?> publishKafkaMessage(@Valid @RequestBody KafkaRequest request) {

        String isSuccess = kafkaService.publishMessage(request);
        return ResponseEntity.ok(isSuccess);

    }




}
