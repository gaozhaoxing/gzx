package cn.ys.mq.rpc.netty.server;

/**
 * Created by caoyuan on 2015-6-26
 */
public interface Handler {
    byte[] messageReceived(byte[] message);
}
