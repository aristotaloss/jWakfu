package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.model.WorldInfo;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class Packet1200ListWorlds implements OutgoingPacket {
	
	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(1200);
		
		buffer.writeByte(WorldInfo.getWorldCount());
		for (WorldInfo info : WorldInfo.getList()) {
			encodeWorld(info, buffer);
		}
		
		buffer.printBuffer(true);
		return buffer;
	}
	
	private void encodeWorld(WorldInfo world, OutPacket buffer) {
		buffer.markByte(0);
		buffer.writeByte(3); //Amount of infoblocks
		
		{ //Block offsets
			buffer.writeByte(0); //Block id 0
			buffer.markInt(1);
			
			buffer.writeByte(1); //Block id 1
			buffer.markInt(2);
			
			buffer.writeByte(2); //Block id 2
			buffer.markInt(3);
		}
		
		{ //Actual blocks
			buffer.endMarkIntAbsolute(1, -6);
			buffer.writeByte(0); //Id
			buffer.writeInt(world.getId());
			buffer.writeString("1W");
			
			buffer.endMarkIntAbsolute(2, -6);
			buffer.writeByte(1); //Id
			buffer.writeString(world.getName());
			buffer.writeString("en");
			
			buffer.endMarkIntAbsolute(3, -6);
			buffer.writeByte(2); //Id
			buffer.writeByte(1); //online
			buffer.writeByte(0); //full
			buffer.writeByte(0); //population
		}
		
		buffer.endMarkByte(0, -1);
	}

}
