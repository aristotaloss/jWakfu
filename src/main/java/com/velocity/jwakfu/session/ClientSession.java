package com.velocity.jwakfu.session;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.util.LoggingUtil;
import io.netty.channel.Channel;

import com.velocity.jwakfu.model.Player;
import com.velocity.jwakfu.net.packets.OutgoingPacket;
import org.slf4j.Logger;

public class ClientSession {

	private static final Logger logger = LoggingUtil.log();
	
	private Channel channel;
	private Player player;
	
	public ClientSession(Channel channel) {
		this.channel = channel;
	}
	
	public Channel getChannel() {
		return channel;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public ClientSession write(Object data) {
		if (data instanceof OutgoingPacket) {
			OutPacket out = ((OutgoingPacket) data).encode();
			logger.info("Outgoing packet: {} ({}), size {}.", out.getPacketId(), data.getClass().getSimpleName(), out.getData().writerIndex());
			channel.writeAndFlush(out);
			return this;
		}
		
		channel.writeAndFlush(data);
		return this;
	}
	
}
