package com.velocity.jwakfu.net.packets.out;

import com.sun.xml.internal.ws.client.ResponseContext;
import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;
import com.velocity.jwakfu.net.packets.out.enums.LoginResponseCode;

/**
 * Created by Bart on 1/14/2017.
 */
public class Packet1027LoginResponse implements OutgoingPacket {

	private LoginResponseCode code;

	public Packet1027LoginResponse(LoginResponseCode code) {
		this.code = code;
	}

	@Override
	public OutPacket encode() {
		OutPacket out = new OutPacket(1027);

		out.writeByte(code.getCode());

		if (code == LoginResponseCode.CORRECT_LOGIN) {
			out.writeByte(1);

			out.writeInt(7); // Community
			out.writeByte(0); // Has admin info
		} else {
			out.writeByte(0);
		}

		return out;
	}

}
