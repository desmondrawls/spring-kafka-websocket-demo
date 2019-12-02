package com.springKafka.liveDashboard.controllers;

import com.springKafka.liveDashboard.services.Source3;
import com.springKafka.liveDashboard.temperature.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;

@Controller
@EnableBinding(Source3.class)
public class StreamSource3 {

  @Autowired
  private Source3 source;

  @MessageMapping("/topic/ws-temperature-source-kinda-hot")
  public void record(int temperature) throws Exception {
    Thread.sleep(1000);
    System.out.println("recording: " + temperature + 100);
    Reading reading = new Reading(temperature + 100);
    source.output().send(MessageBuilder.withPayload(reading).build());
    System.out.println("after sending");
  }
}
