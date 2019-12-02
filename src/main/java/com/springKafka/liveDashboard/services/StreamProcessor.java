package com.springKafka.liveDashboard.services;

import com.springKafka.liveDashboard.temperature.Reading;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(StreamProcessor.Processor2.class)
public class StreamProcessor {

    @StreamListener(Processor2.INPUT)
    @SendTo(Processor2.OUTPUT)
    public Reading processData(Reading reading) {
        return new Reading(reading.temperature + 200);
    }


    public interface Processor2 {
        String INPUT = "temperature";
        String OUTPUT = "temperature-hot";

        @Input(INPUT)
        MessageChannel input();

        @Output(OUTPUT)
        MessageChannel output();

    }
}
