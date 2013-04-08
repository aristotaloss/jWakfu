package com.velocity.jwakfu.net.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

@Sharable
public class MessageDecoder extends ByteToMessageDecoder<ByteBuf> {

	@Override
	public ByteBuf decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		ByteBuf buf = Unpooled.buffer();
		buf.writeBytes(in);
		return buf;
	}

}
