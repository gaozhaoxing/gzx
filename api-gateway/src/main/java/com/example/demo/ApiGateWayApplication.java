package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@EnableZuulProxy

@EnableFeignClients(basePackages = { "cn.ys", "com.example" })
@SpringCloudApplication
public class ApiGateWayApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ApiGateWayApplication.class).web(true).run(args);
	}
}
