package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class Packet2054CharCreationResponse implements OutgoingPacket {

	@Override
	public OutPacket encode() {
		OutPacket packet = new OutPacket(2054);
		packet.writeByte(0); //TODO: add other options
		return packet;
	}

}