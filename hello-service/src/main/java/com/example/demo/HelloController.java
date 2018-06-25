package com.example.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
public class HelloController {
	private final Logger logger = Logger.getLogger(getClass());

	@RequestMapping("/hello")
    public String index(@RequestParam String name) {
		logger.info("hello "+name+"，this is first messge");
        return "hello "+name+"，this is first messge";
    }
	@RequestMapping("/hello2")
    public String index2(@RequestBody List<String> name) {
		logger.info("hello2 "+name.get(0)+"，this is first messge");
        return "hello2 "+name.get(0)+"，this is first messge";
    }
}
