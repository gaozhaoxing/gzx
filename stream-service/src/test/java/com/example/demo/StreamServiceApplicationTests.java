package com.example.demo;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@EnableBinding(value = { SinkSender.class })
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamServiceApplicationTests {
	private final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private SinkSender sinkSender;

	@Test
	public void contextLoads() {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(2000);
				sinkSender.output1().send(MessageBuilder.withPayload(new Date()).build());
				sinkSender.output2().send(MessageBuilder.withPayload(new Date().getTime()).build());
				logger.info("send------------------------------->>>>:" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
