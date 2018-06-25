package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigurationProperties()
@RestController
public class TestController {
	@Autowired
	private ConfigProperties configProperties;

	@RequestMapping("/test")
	public @ResponseBody String test() {
		System.out.println("--------->>>" + configProperties.getPort());
		return "ok";
	}
}
