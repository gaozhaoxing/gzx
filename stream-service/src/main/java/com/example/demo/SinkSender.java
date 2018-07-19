package com.example.demo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {
	String OUTPUT0 = "gaozhaoxing_input_0";
	String OUTPUT1 = "gaozhaoxing_input_1";
	String OUTPUT2 = "gaozhaoxing_input_2";

	@Output(OUTPUT0)
	MessageChannel output0();

	@Output(OUTPUT1)
	MessageChannel output1();

	@Output(OUTPUT2)
	MessageChannel output2();
}