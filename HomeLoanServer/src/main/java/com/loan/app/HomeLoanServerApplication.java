package com.loan.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class HomeLoanServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeLoanServerApplication.class, args);
		System.out.println("This Is Our HomeLoan Server");
	}

}
