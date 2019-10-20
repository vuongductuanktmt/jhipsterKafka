package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.JhipsterKafkaKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jhipster-kafka-kafka")
public class JhipsterKafkaKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterKafkaKafkaResource.class);

    private JhipsterKafkaKafkaProducer kafkaProducer;

    public JhipsterKafkaKafkaResource(JhipsterKafkaKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
