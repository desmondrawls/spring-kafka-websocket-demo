package com.springKafka.liveDashboard.services;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Sink2 {
    String INPUT = "temperature";

    @Output(Sink2.INPUT)
    MessageChannel input();
}
