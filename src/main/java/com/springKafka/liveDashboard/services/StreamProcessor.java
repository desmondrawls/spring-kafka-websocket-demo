package com.springKafka.liveDashboard.services;

import com.springKafka.liveDashboard.temperature.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

//@EnableBinding(Processor.class)
//public class StreamProcessor {
//
//    @StreamListener("temperature")
//    @SendTo("temperature-hot")
//    public Reading consume(@Payload Reading reading) {
//        System.out.println("reading: " + reading);
//        return new Reading(reading.temperature + 100);
//    }
//}
