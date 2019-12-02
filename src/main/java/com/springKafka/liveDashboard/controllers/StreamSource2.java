package com.springKafka.liveDashboard.controllers;

import com.springKafka.liveDashboard.services.Source2;
import com.springKafka.liveDashboard.temperature.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;

@Controller
@EnableBinding(Source2.class)
public class StreamSource2 {

  @Autowired
  private Source2 source;

  @MessageMapping("/topic/ws-temperature-source-hot")
  public void record(int temperature) throws Exception {
    Thread.sleep(1000);
    System.out.println("recording: " + temperature + 100);
    Reading reading = new Reading(temperature + 100);
    source.output().send(MessageBuilder.withPayload(reading).build());
    System.out.println("after sending");
  }
}
