package com.loan.losa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class LoanSanctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanSanctionApplication.class, args);
		System.out.println("This Our Loan Sanction Module");
	}

}
