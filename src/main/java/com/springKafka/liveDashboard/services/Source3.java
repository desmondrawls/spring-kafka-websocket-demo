package com.springKafka.liveDashboard.services;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source3 {
    String OUTPUT = "temperature-kinda-hot";

    @Output(Source3.OUTPUT)
    MessageChannel output();
}
