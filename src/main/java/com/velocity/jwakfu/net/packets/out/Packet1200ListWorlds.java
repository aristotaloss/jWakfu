package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.model.WorldInfo;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class Packet1200ListWorlds implements OutgoingPacket {

	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(1036);

		buffer.writeInt(WorldInfo.getWorldCount());
		for (WorldInfo info : WorldInfo.getList()) {
			encodeWorld(info, buffer);
		}

		buffer.writeInt(WorldInfo.getWorldCount());
		for (WorldInfo info : WorldInfo.getList()) {
			buffer.writeInt(info.getId());

			// Version info
			buffer.writeInt(1 + 2 + 1 + 1 + 2);
			buffer.writeByte(1);
			buffer.writeShort(50);
			buffer.writeByte(2);
			buffer.writeString("-1");

			buffer.writeInt(4); // info len
			buffer.writeInt(0); // no entries

			buffer.writeByte(0); // locked
		}

		return buffer;
	}

	private void encodeWorld(WorldInfo world, OutPacket buffer) {
		buffer.writeInt(world.getId());
		buffer.writeLargeString(world.getName());
		buffer.writeInt(1); // community
		buffer.writeLargeString("0.0.0.0");
		buffer.writeInt(1); // number of ports
		buffer.writeInt(5558); // port
		buffer.writeByte(6); // order
	}

}