package com.example.demo;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		System.out.println("Sender : " + context);
		try {
			this.rabbitTemplate.convertSendAndReceive("exchangeTest", "gaozhaoxing_queueKey_direct-exchange", context);
			System.out.println("Sender-------------------->>>> : " + context);
			Thread.sleep(3000);
			this.rabbitTemplate.convertSendAndReceive("exchangeTest", "gaozhaoxing_queueKey_direct-exchange", context);
			System.out.println("Sender-------------------->>>> : " + context);
			Thread.sleep(3000);
			this.rabbitTemplate.convertSendAndReceive("exchangeTest", "gaozhaoxing_queueKey_direct-exchange", context);
			System.out.println("Sender-------------------->>>> : " + context);
			Thread.sleep(3000);
			this.rabbitTemplate.convertSendAndReceive("exchangeTest", "gaozhaoxing_queueKey_direct-exchange", context);
			System.out.println("Sender-------------------->>>> : " + context);
			Thread.sleep(3000);
			this.rabbitTemplate.convertSendAndReceive("exchangeTest", "gaozhaoxing_queueKey_direct-exchange", context);
			System.out.println("Sender-------------------->>>> : " + context);
		} catch (InterruptedException e) {
		}
	}
}
