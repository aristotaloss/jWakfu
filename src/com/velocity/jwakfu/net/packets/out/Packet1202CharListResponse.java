package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class Packet1202CharListResponse implements OutgoingPacket {

	private int worldId;
	private boolean success;
	
	public Packet1202CharListResponse(int worldId, boolean success) {
		this.worldId = worldId;
		this.success = success;
	}
	
	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(1202);
		
		buffer.writeInt(worldId);
		buffer.writeByte(success ? 0 : 1);
		
		return buffer;
	}

}
