package cn.ys.mq.rpc.netty.server;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ys.common.logger.Logger;
import cn.ys.common.logger.LoggerFactory;
import cn.ys.services.rpc.constants.RpcProperties;
import cn.ys.services.rpc.netty.http.server.NettyHttpServer;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;

public class MqServer {
	private static final Logger logger = LoggerFactory.getLogger(MqServer.class);
	private Channel channel = null;
	private EventLoopGroup bossGroup = null;
	private EventLoopGroup workerGroup = null;
	private AtomicBoolean startFlag = new AtomicBoolean(false);

	public static void main(String[] args) {
		try {
			System.setProperty("config", (new File(System.getProperty("user.dir"), "/config")).getCanonicalPath());
		} catch (IOException e) {
			System.exit(0);
			logger.error("load properties key err", e);
		}
		// 启动spring环境
		new ClassPathXmlApplicationContext("applicationContext.xml");
		try {
			// 对内发布rpc服务
			NettyHttpServer nettyServer = new NettyHttpServer();
			nettyServer.start("MQ服务", 
					Integer.valueOf(RpcProperties.getInstance().getProperty("port")).intValue(), 
					Integer.valueOf(RpcProperties.getInstance().getProperty("bossThreadNum")).intValue(), 
					Integer.valueOf(RpcProperties.getInstance().getProperty("workerThreadNum")).intValue(), 
					Integer.valueOf(RpcProperties.getInstance().getProperty("businessThreadNum")).intValue());
		} catch (Exception e) {
			logger.error("", e);
		}
	}

	public static void start() {
		try {
			System.setProperty("config", (new File(System.getProperty("user.dir"), "../config")).getCanonicalPath());
		} catch (IOException e) {
			System.exit(0);
			logger.error("load properties key err", e);
		}
		// 启动spring环境
		new ClassPathXmlApplicationContext("applicationContext.xml");
		try {
			// 对内发布rpc服务
			NettyHttpServer nettyServer = new NettyHttpServer();
			nettyServer.start("MQ服务", 
					Integer.valueOf(RpcProperties.getInstance().getProperty("port")).intValue(), 
					Integer.valueOf(RpcProperties.getInstance().getProperty("bossThreadNum")).intValue(), 
					Integer.valueOf(RpcProperties.getInstance().getProperty("workerThreadNum")).intValue(), 
					Integer.valueOf(RpcProperties.getInstance().getProperty("businessThreadNum")).intValue());
		} catch (Exception e) {
			logger.error("", e);
		}
	}

	public void stop() throws Exception {
		logger.debug("Server stop!");
		channel.close();
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
		startFlag.set(false);
	}
}
