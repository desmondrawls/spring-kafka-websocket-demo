package com.springKafka.liveDashboard.services;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SourceWebFlux {
    String OUTPUT = "temperature-webflux";

    @Output(SourceWebFlux.OUTPUT)
    MessageChannel output();
}
