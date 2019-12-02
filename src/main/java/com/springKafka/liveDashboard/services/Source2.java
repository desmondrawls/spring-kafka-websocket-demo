package com.springKafka.liveDashboard.services;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source2 {
    String OUTPUT = "temperature-hot";

    @Output(Source2.OUTPUT)
    MessageChannel output();
}
