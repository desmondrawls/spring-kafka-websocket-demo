package com.springKafka.liveDashboard.employee;

import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

public class EmployeeController {

    @GetMapping
    private Flux<Integer> getAllTemperatures() {

    }
}
