package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class StreamServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StreamServiceApplication.class, args);
	}
}
