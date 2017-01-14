package com.velocity.jwakfu.net.packets.in;

import com.velocity.jwakfu.net.packets.IncomingPacket;
import com.velocity.jwakfu.net.packets.out.Packet2079SetWebSessionToken;
import com.velocity.jwakfu.session.ClientSession;
import io.netty.buffer.ByteBuf;

/**
 * Created by Bart on 1/14/2017.
 */
public class Packet2079RequestWebSessionToken implements IncomingPacket {

	@Override
	public void decode(ClientSession session, ByteBuf buffer, int size) {
		session.write(new Packet2079SetWebSessionToken());
	}

}
