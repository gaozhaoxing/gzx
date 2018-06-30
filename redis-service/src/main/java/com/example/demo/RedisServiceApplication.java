package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class RedisServiceApplication {
	public static void main(String[] args) {
		//new SpringApplicationBuilder(RedisServiceApplication.class).web(true).run(args);
		SpringApplication.run(RedisServiceApplication.class, args);
	}
}