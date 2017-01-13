package com.velocity.jwakfu.session;

import io.netty.channel.Channel;

import com.velocity.jwakfu.model.Player;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class ClientSession {
	
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
			channel.writeAndFlush(((OutgoingPacket) data).encode());
			return this;
		}
		
		channel.writeAndFlush(data);
		return this;
	}
	
}
