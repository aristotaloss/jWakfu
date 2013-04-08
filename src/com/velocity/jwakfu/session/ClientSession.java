package com.velocity.jwakfu.session;

import io.netty.channel.Channel;

public class ClientSession {
	
	private Channel channel;
	
	public ClientSession(Channel channel) {
		this.channel = channel;
	}
	
	public Channel getChannel() {
		return channel;
	}
	
}
