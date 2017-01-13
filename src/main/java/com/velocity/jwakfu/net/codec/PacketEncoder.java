package com.velocity.jwakfu.net.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;

import org.slf4j.Logger;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.util.LoggingUtil;

import java.util.List;

@Sharable
public class PacketEncoder extends MessageToByteEncoder<OutPacket> {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggingUtil.log();
	
	public PacketEncoder() {
		super(OutPacket.class);
	}
	
    @Override
    public void encode(ChannelHandlerContext ctx, OutPacket msg, ByteBuf out) throws Exception {
    	msg.finish();
    	out.writeBytes(msg.getData());
    	ctx.channel().flush();
    }
    
}
