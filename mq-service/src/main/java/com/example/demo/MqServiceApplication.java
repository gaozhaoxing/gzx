package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import cn.ys.common.logger.Logger;
import cn.ys.common.logger.LoggerFactory;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class MqServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(MqServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MqServiceApplication.class, args);
	}
}
