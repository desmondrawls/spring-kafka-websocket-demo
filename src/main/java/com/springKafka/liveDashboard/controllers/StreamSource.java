package com.springKafka.liveDashboard.controllers;

import com.springKafka.liveDashboard.temperature.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;

@Controller
@EnableBinding(Source.class)
public class StreamSource {

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


