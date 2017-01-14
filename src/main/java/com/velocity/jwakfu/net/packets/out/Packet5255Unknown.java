package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

/**
 * Created by Bart on 1/14/2017.
 */
public class Packet5255Unknown implements OutgoingPacket {

	@Override
	public OutPacket encode() {
		OutPacket out = new OutPacket(5255);
		out.writeInt(0);
		return out;
	}

}
