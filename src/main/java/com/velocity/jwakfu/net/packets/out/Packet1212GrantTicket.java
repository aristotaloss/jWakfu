package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

/**
 * Created by Bart on 1/14/2017.
 */
public class Packet1212GrantTicket implements OutgoingPacket {

	private String ticket;

	public Packet1212GrantTicket(String ticket) {
		this.ticket = ticket;
	}

	@Override
	public OutPacket encode() {
		OutPacket out = new OutPacket(1212);
		out.writeByte(0); // Error code
		out.writeLargeString(ticket);
		return out;
	}

}
