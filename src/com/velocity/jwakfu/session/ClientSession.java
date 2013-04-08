package com.velocity.jwakfu.session;

import com.velocity.jwakfu.net.packets.OutgoingPacket;

import io.netty.channel.Channel;

public class ClientSession {
	
	private Channel channel;
	
	public ClientSession(Channel channel) {
		this.channel = channel;
	}
	
	public Channel getChannel() {
		return channel;
	}
	
	public ClientSession write(Object data) {
		if (data instanceof OutgoingPacket) {
			channel.write(((OutgoingPacket) data).encode());
			return this;
		}
		
		channel.write(data);
		return this;
	}
	
}
