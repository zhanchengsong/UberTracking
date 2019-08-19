package dev.newgrad.locationsimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LocationSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationSimulatorApplication.class, args);
	}

}
