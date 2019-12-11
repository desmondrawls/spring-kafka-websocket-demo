package com.springKafka.liveDashboard.employee;

import com.springKafka.liveDashboard.temperature.Reading;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.util.RouteMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverRecord;

@RestController
public class EmployeeController {

    private KafkaReceiver<Object, Reading> kafkaReceiver;

    public EmployeeController(KafkaReceiver kafkaReceiver) {
        this.kafkaReceiver = kafkaReceiver;
    }

    @GetMapping("/getAllTemperatures")
    public Flux<Integer> getAllTemperatures() {
        Flux<ReceiverRecord<Object, Reading>> receive = kafkaReceiver.receive();
        Flux<Integer> temps = receive.map((a) -> a.value().temperature);
        Flux<Integer> max = temps.scan(Math::max);
        return max;
    }

    @GetMapping("/getATemperature")
    @ResponseBody
    private Mono<Integer> getATemperature() {
        return Mono.just(88);
    }
}
