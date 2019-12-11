package com.springKafka.liveDashboard;

import com.springKafka.liveDashboard.employee.Employee;
import com.springKafka.liveDashboard.employee.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.springKafka")
public class LiveDashboardApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(LiveDashboardApplication.class, args);
		
	}
}
