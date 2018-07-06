package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class SinkReceiverController {
	private final Logger logger = Logger.getLogger(getClass());

	@StreamListener(Sink.INPUT)
	public void receive(Object obj) {
		logger.debug("Received------------------->>>>:" + obj);
	}
}