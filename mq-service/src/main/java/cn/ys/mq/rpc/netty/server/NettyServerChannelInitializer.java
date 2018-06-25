package cn.ys.mq.rpc.netty.server;
import java.net.InetSocketAddress;

import cn.ys.common.logger.Logger;
import cn.ys.common.logger.LoggerFactory;
import cn.ys.services.common.ConfigProperties;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {
	private static final Logger logger = LoggerFactory.getLogger(NettyServerChannelInitializer.class);
	private static final EventExecutorGroup group = new DefaultEventExecutorGroup(Integer.valueOf(ConfigProperties.getInstance().getProperty("businessThreadNum").trim()), new NamedThreadFactory("NETTYSERVER-BUSINESS-" + ConfigProperties.getInstance().getProperty("businessThreadNum") + "-"));
	private String service;

	public NettyServerChannelInitializer(String service) {
		this.service = service;
	}

	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		InetSocketAddress i = ch.remoteAddress();
		ChannelPipeline pipeline = ch.pipeline();
		logger.debug("[客户端IP:" + i.getAddress().getHostAddress() + "][端口:" + i.getPort() + "]");
		pipeline.addLast("decoder", new LengthDecoder());
		pipeline.addLast(group, new NettyServerHandler(service));
	}
}