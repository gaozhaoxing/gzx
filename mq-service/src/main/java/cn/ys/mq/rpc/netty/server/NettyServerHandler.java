package cn.ys.mq.rpc.netty.server;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

import cn.ys.common.logger.Logger;
import cn.ys.common.logger.LoggerFactory;
import cn.ys.protocol.common.util.ByteUtil;
import cn.ys.services.rpc.spring.SpringContextHolderEnum;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);
	private String service;

	public NettyServerHandler(String service) {
		this.service = service;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object object) throws Exception {
		byte[] message = (byte[]) object;
		// 业务处理
		Handler bh = SpringContextHolderEnum.INSTANCE.getBean(service);
		byte[] returnByte = bh.messageReceived(message);
		if (Arrays.equals(ArrayUtils.subarray(returnByte, 30, 34), ByteUtil.codeBCD("00010001"))) {
			ctx.channel().close();
		}
		if (returnByte != null) {
			ByteBuf byteBuf = ctx.alloc().heapBuffer(returnByte.length);
			byteBuf.writeBytes(returnByte);
			ChannelFuture wf = ctx.channel().writeAndFlush(byteBuf);
			wf.addListener(new ChannelFutureListener() {
				@Override
				public void operationComplete(ChannelFuture future) {
					if (!future.isSuccess()) {
						logger.debug("write back fail {}", future.channel().remoteAddress());
					}
				}
			});
		}
	}
}
