package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class Packet2056LeaveCharScreen implements OutgoingPacket {

	@Override
	public OutPacket encode() {
		OutPacket packet = new OutPacket(2056);
		return packet;
	}

}
