package com.velocity.jwakfu.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

import org.slf4j.Logger;

import com.velocity.jwakfu.session.ClientSession;
import com.velocity.jwakfu.util.LoggingUtil;

@Sharable
public class GameServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

	private static final Logger logger = LoggingUtil.log();
	public static final AttributeKey<ClientSession> CLIENTSESS_ATTR = AttributeKey.newInstance("ClientSession");
	
	public GameServerHandler() {
		super(ByteBuf.class);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.channel().attr(CLIENTSESS_ATTR).setIfAbsent(new ClientSession(ctx.channel()));
		logger.info("A new channel is active: " + ctx.channel());
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		ClientSession sess = ctx.channel().attr(CLIENTSESS_ATTR).get();
		logger.info("Channel inactive: " + sess);
		//TODO: deregister from list
 	}
	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
	}
	
	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, ByteBuf packet) throws Exception {
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}