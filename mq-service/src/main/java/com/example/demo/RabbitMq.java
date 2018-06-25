package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq", ignoreUnknownFields = false)
@PropertySource(value ={"file:${user.dir}/application.properties"}, ignoreResourceNotFound = true)  
public class RabbitMq {
	
}
