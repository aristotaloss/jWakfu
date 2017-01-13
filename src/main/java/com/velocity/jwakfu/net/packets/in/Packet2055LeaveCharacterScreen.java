package com.velocity.jwakfu.net.packets.in;

import io.netty.buffer.ByteBuf;

import com.velocity.jwakfu.net.packets.IncomingPacket;
import com.velocity.jwakfu.net.packets.out.Packet2056LeaveCharScreen;
import com.velocity.jwakfu.session.ClientSession;

public class Packet2055LeaveCharacterScreen implements IncomingPacket {

	@Override
	public void decode(ClientSession session, ByteBuf buffer, int size) {
		session.write(new Packet2056LeaveCharScreen());
	}

}
