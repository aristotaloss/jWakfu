package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class Packet2063ServerTime implements OutgoingPacket {

	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(2063);
		buffer.writeLong(System.currentTimeMillis());
		return buffer;
	}

}
