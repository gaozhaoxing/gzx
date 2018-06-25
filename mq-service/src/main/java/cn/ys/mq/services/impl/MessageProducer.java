package cn.ys.mq.services.impl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import cn.iszt.services.mq.api.MessageProducerService;
import cn.ys.common.logger.Logger;
import cn.ys.common.logger.LoggerFactory;
import cn.ys.protocol.redis.api.RedisClusterService;
import cn.ys.services.rpc.constants.RpcProperties;

@Service
public class MessageProducer implements MessageProducerService {
	private Logger logger = LoggerFactory.getLogger(MessageProducer.class);
	@Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	private RedisClusterService redisClusterService;

	@Override
	public Object sendMessage(Object message) {
		logger.debug("向队列发送message:{}", message);
		amqpTemplate.convertAndSend(RpcProperties.getInstance().getProperty("rabbit.queueKey"), message);
		return message + "已发送完毕------------OK--------OK-------------";
	}
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory cf=new ConnectionFactory();
		cf.setHost("192.168.2.128");
		cf.setPort(5672);
		cf.setUsername("gaozhaoxing");
		cf.setPassword("123456");
		Channel ccc=cf.newConnection().createChannel();
		
	}
}