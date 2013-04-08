package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;
import com.velocity.jwakfu.net.packets.out.enums.LoginResponseCode;

public class Packet1024LoginResponse implements OutgoingPacket {

	private static final int PACKET_ID = 1024;
	
	private LoginResponseCode responseCode;
	
	public Packet1024LoginResponse(LoginResponseCode responseCode) {
		this.responseCode = responseCode;
	}
	
	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(PACKET_ID);
		buffer.writeByte(responseCode.getCode());
		return buffer;
	}

}
