package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.crypto.RSACertificateManager;
import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class Packet1032RSAKey implements OutgoingPacket {
	
	private static final int PACKET_ID = 1034;
	public static final long RSA_VERIFICATION_LONG = 0x8000000000000000L;

	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(PACKET_ID);
		
		buffer.writeLong(RSA_VERIFICATION_LONG);
		buffer.writeBytes(RSACertificateManager.INSTANCE.getPublicKey());
		
		return buffer;
	}

}
