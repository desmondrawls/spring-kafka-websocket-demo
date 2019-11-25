package com.springKafka.liveDashboard.controllers;

import com.springKafka.liveDashboard.temperature.Reading;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class Thermostat {

  @Autowired
  private KafkaTemplate<String, Reading> kafkaTemplate;

  @MessageMapping("/topic/ws-temperature-source")
  public void record(int temperature) throws Exception {
    Thread.sleep(1000);
    System.out.println("recording: " + temperature);
    Reading reading = new Reading(temperature);
    kafkaTemplate.send("temperature", reading.day.toString(), reading);
    System.out.println("after sending");
  }

}
