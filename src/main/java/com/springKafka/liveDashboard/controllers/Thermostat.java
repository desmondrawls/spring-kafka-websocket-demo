package com.springKafka.liveDashboard.controllers;

import com.springKafka.liveDashboard.temperature.Reading;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
@EnableBinding(Source.class)
public class Thermostat {

  @Autowired
  private Source source;

  @MessageMapping("/topic/ws-temperature-source")
  public void record(int temperature) throws Exception {
    Thread.sleep(1000);
    System.out.println("recording: " + temperature);
    Reading reading = new Reading(temperature);
    source.output().send(MessageBuilder.withPayload(reading).build());
    System.out.println("after sending");
  }

}
