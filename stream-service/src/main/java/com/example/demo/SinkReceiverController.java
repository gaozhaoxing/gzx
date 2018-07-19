package com.example.demo;

import org.apache.log4j.Logger;

//@EnableBinding(SinkReceiver.class)
public class SinkReceiverController {
	private final Logger logger = Logger.getLogger(getClass());

//	@StreamListener(SinkReceiver.INPUT0)
//	public void receive0(Message<Object> obj) {
//		logger.info("Received0------->>>>:" + obj.getHeaders() + "----->>" + obj.getPayload());
//	}
//
//	@StreamListener(SinkReceiver.INPUT1)
//	public void receive1(Message<Object> obj) {
//		logger.info("Received1------->>>>:" + obj.getHeaders() + "----->>" + obj.getPayload());
//	}
//
//	@StreamListener(SinkReceiver.INPUT2)
//	public void receive2(Message<Object> obj) {
//		logger.info("Received2------->>>>:" + obj.getHeaders() + "----->>" + obj.getPayload());
//	}
}