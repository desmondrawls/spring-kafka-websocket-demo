package com.springKafka.liveDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.springKafka")
public class LiveDashboardApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(LiveDashboardApplication.class, args);
		
	}
}
