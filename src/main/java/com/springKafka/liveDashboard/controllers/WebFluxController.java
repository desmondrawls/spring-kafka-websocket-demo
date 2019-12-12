package com.springKafka.liveDashboard.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springKafka.liveDashboard.services.SourceWebFlux;
import com.springKafka.liveDashboard.temperature.Reading;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverRecord;

import java.time.Duration;

@RestController
@EnableBinding(SourceWebFlux.class)
public class WebFluxController {

    private SourceWebFlux sourceWebFlux;
    private KafkaReceiver kafkaReceiver;
    private ObjectMapper objectMapper;

    public WebFluxController(KafkaReceiver kafkaReceiver, SourceWebFlux sourceWebFlux, ObjectMapper objectMapper) {
        this.kafkaReceiver = kafkaReceiver;
        this.sourceWebFlux = sourceWebFlux;
        this.objectMapper = objectMapper;
    }

    @MessageMapping("/topic/ws-temperature-source-webflux")
    public void record(int temperature) throws Exception {
        Thread.sleep(1000);
        Reading reading = new Reading(temperature);
        String messageToSend = objectMapper.writeValueAsString(reading);
        System.out.println("recording: " + messageToSend);
        sourceWebFlux.output()
                .send(
                        MessageBuilder
                                .withPayload(messageToSend)
                                .build());
        System.out.println("after sending");
    }

    @GetMapping(value = "/getAllTemperatures", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Reading> getAllTemperatures() {
        Flux<ReceiverRecord<String, String>> receive = kafkaReceiver.receive();
        Flux<Reading> temps = receive.map((a) ->
        {
            try {
                return objectMapper.readValue(a.value(), Reading.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return new Reading(999);
            }
        });

        return temps;
    }

    @GetMapping(value = "/getATemperature", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    private Flux<Long> getATemperature() {
        return Flux.interval(Duration.ofSeconds(1));
    }
}
