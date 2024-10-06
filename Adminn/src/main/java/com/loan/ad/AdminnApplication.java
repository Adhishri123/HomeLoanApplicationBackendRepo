package com.loan.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class AdminnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminnApplication.class, args);
		System.out.println("This Is Our Admin Module");
	}

}
