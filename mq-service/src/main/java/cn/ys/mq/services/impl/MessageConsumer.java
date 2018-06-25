package cn.ys.mq.services.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

import cn.ys.common.logger.Logger;
import cn.ys.common.logger.LoggerFactory;

/**
 * 
 * @Description 消费接收
 */
@Service
public class MessageConsumer implements ChannelAwareMessageListener {
	private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

	public void onMessage(Message message) {
		logger.debug("收到队列传递 message:{}", message);
	}

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		logger.debug("收到队列传递 message:{}", message);
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}
}