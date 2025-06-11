package com.crypto.scheduler;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoSchedulerApplication.class, args);
	}

}
