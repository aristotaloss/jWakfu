package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class Packet2052DeleteCharacter implements OutgoingPacket {

	private long id;
	private boolean success;

	public Packet2052DeleteCharacter(long id, boolean success) {
		this.id = id;
		this.success = success;
	}

	@Override
	public OutPacket encode() {
		OutPacket packet = new OutPacket(2052);
		packet.writeLong(id);
		packet.writeByte(success ? 1 : 0);
		return packet;
	}

}