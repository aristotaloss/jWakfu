package com.velocity.jwakfu.net.packets.in;

import io.netty.buffer.ByteBuf;

import com.velocity.jwakfu.net.packets.IncomingPacket;
import com.velocity.jwakfu.net.packets.out.Packet2052DeleteCharacter;
import com.velocity.jwakfu.session.ClientSession;

public class Packet2051DeleteCharacter implements IncomingPacket {

	@Override
	public void decode(ClientSession session, ByteBuf buffer, int size) {
		long charId = buffer.readLong();
		
		for (int i=0; i<session.getPlayer().getCharacters().size(); i++) {
			if (session.getPlayer().getCharacters().get(i).getId() == charId) {
				session.getPlayer().getCharacters().remove(i);
				session.getPlayer().save();
				session.write(new Packet2052DeleteCharacter(charId, true));
				return;
			}
		}
		
		session.write(new Packet2052DeleteCharacter(charId, false));
		return;
	}

}
