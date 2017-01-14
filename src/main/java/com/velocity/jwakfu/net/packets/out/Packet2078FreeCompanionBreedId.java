package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

/**
 * Created by Bart on 1/14/2017.
 */
public class Packet2078FreeCompanionBreedId implements OutgoingPacket {

	@Override
	public OutPacket encode() {
		OutPacket out = new OutPacket(2078);
		out.writeShort(2829);
		return out;
	}
}
