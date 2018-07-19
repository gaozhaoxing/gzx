package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SinkReceiver {
	String INPUT0 = "gaozhaoxing_input_0";
	String INPUT1 = "gaozhaoxing_input_1";
	String INPUT2 = "gaozhaoxing_input_2";

	@Input(INPUT0)
	SubscribableChannel input0();

	@Input(INPUT1)
	SubscribableChannel input1();

	@Input(INPUT2)
	SubscribableChannel input2();
}
