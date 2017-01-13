package com.velocity.jwakfu.net.packets.in;

import com.velocity.jwakfu.net.packets.IncomingPacket;
import com.velocity.jwakfu.net.packets.out.Packet1200ListWorlds;
import com.velocity.jwakfu.net.packets.out.Packet1202CharListResponse;
import com.velocity.jwakfu.net.packets.out.Packet2048SendCharacters;
import com.velocity.jwakfu.net.packets.out.Packet2063ServerTime;
import com.velocity.jwakfu.session.ClientSession;
import com.velocity.jwakfu.util.LoggingUtil;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;

public class Packet1035RefreshWorlds implements IncomingPacket {

	private static final Logger logger = LoggingUtil.log();
	
	@Override
	public void decode(ClientSession session, ByteBuf buffer, int size) {
		session.write(new Packet1200ListWorlds());
	}

}
