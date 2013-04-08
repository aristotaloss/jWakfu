package com.velocity.jwakfu.net;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import com.velocity.jwakfu.net.codec.MessageDecoder;
import com.velocity.jwakfu.net.codec.PacketDecoder;
import com.velocity.jwakfu.net.codec.PacketEncoder;

public class GameServerInitializer extends ChannelInitializer<SocketChannel> {
	
	private static final PacketDecoder DECODER = new PacketDecoder();
    private static final PacketEncoder ENCODER = new PacketEncoder();
    private static final GameServerHandler SERVERHANDLER = new GameServerHandler();

    @Override
    public void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pl = channel.pipeline();

        pl.addLast("framer", new MessageDecoder());
        pl.addLast("decoder", DECODER);
        pl.addLast("encoder", ENCODER);
        pl.addLast("handler", SERVERHANDLER);
    }
}
