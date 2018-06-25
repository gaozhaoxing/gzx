package com.example.demo;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ys.common.logger.Logger;
import cn.ys.common.logger.LoggerFactory;
import cn.ys.services.rpc.constants.RpcProperties;
import cn.ys.services.rpc.netty.http.server.NettyHttpServer;

@Configuration
@EnableConfigurationProperties(ConfigProperties.class)
public class StartServer {
	private static final Logger logger = LoggerFactory.getLogger(StartServer.class);

	public void doStart() {
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
			nettyServer.start("MQ服务", Integer.valueOf(RpcProperties.getInstance().getProperty("port")).intValue(), Integer.valueOf(RpcProperties.getInstance().getProperty("bossThreadNum")).intValue(), Integer.valueOf(RpcProperties.getInstance().getProperty("workerThreadNum")).intValue(), Integer.valueOf(RpcProperties.getInstance().getProperty("businessThreadNum")).intValue());
		} catch (Exception e) {
			logger.error("", e);
		}
	}
}
