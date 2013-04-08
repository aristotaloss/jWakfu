package com.velocity.jwakfu.net.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import org.slf4j.Logger;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.util.LoggingUtil;

@Sharable
public class PacketEncoder extends MessageToMessageEncoder<OutPacket, ByteBuf> {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggingUtil.log();
	
	public PacketEncoder() {
		super(OutPacket.class);
	}
	
    @Override
    public ByteBuf encode(ChannelHandlerContext ctx, OutPacket msg) throws Exception {
    	ByteBuf buf = Unpooled.buffer();
    	msg.finish();
    	buf.writeBytes(msg.getData());
        return buf;
    }
    
}
