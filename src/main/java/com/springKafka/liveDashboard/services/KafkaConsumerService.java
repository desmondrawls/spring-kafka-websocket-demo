package com.springKafka.liveDashboard.services;

import com.springKafka.liveDashboard.temperature.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class KafkaConsumerService{
	
	@Autowired
	SimpMessagingTemplate template;
	
	@StreamListener(Sink.INPUT)
	public void consume(@Payload Reading reading) {
		System.out.println("reading: " + reading);
		template.convertAndSend("/topic/ws-temperature-sink", reading.temperature);
	}
}
