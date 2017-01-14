package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

/**
 * Created by Bart on 1/14/2017.
 */
public class Packet110SetIP implements OutgoingPacket {

	@Override
	public OutPacket encode() {
		OutPacket outPacket = new OutPacket(110);
		outPacket.writeInt(0x5653eeec);
		return outPacket;
	}

}
