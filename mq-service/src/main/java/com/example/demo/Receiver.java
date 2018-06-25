package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "gaozhaoxing_queue_direct-exchange")
public class Receiver {
	@RabbitHandler
	public void process(Object hello) {
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);
		System.out.println("Receiver : " + hello);

	}
}