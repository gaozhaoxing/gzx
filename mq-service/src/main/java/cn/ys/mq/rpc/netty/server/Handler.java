package cn.ys.mq.rpc.netty.server;
public interface Handler {
    byte[] messageReceived(byte[] message);
}
