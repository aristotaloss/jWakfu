package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class Packet2069Unknown implements OutgoingPacket {

	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(2069);

		buffer.writeByte(0);

		return buffer;
	}

}