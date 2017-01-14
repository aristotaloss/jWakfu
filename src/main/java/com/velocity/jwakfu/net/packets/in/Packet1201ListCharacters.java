package com.velocity.jwakfu.net.packets.in;

import io.netty.buffer.ByteBuf;

import org.slf4j.Logger;

import com.velocity.jwakfu.net.packets.IncomingPacket;
import com.velocity.jwakfu.net.packets.out.Packet1202CharListResponse;
import com.velocity.jwakfu.net.packets.out.Packet2077SendCompanions;
import com.velocity.jwakfu.net.packets.out.Packet2063ServerTime;
import com.velocity.jwakfu.session.ClientSession;
import com.velocity.jwakfu.util.LoggingUtil;

public class Packet1201ListCharacters implements IncomingPacket {

	private static final Logger logger = LoggingUtil.log();
	
	@Override
	public void decode(ClientSession session, ByteBuf buffer, int size) {
		int worldId = buffer.readInt();
		logger.info("Character list requested. World: " + worldId);
		
		session.write(new Packet1202CharListResponse(true));
		session.write(new Packet2063ServerTime());
		session.write(new Packet2077SendCompanions(session.getPlayer()));
	}

}
