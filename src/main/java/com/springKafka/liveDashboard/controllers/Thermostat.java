package com.springKafka.liveDashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class Thermostat {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @MessageMapping("/temperature")
  public void record(int temperature) throws Exception {
    Thread.sleep(1000);
    kafkaTemplate.send("temperature", Integer.toString(temperature));
  }

}
