package com.velocity.jwakfu.net.packets;

import io.netty.buffer.ByteBuf;

import com.velocity.jwakfu.session.ClientSession;

public interface IncomingPacket {
	
	public void decode(ClientSession session, ByteBuf buffer, int size);
	
}
