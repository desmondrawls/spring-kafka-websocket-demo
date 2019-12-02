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
@EnableBinding(Source3.class)
public class StreamSink3 {

	@Autowired
	SimpMessagingTemplate template;

	@StreamListener(Source3.OUTPUT)
	public void consume(@Payload Reading reading) {
		System.out.println("reading: " + reading);
		template.convertAndSend("/topic/ws-temperature-sink-3", reading.temperature);
	}
}
