package com.velocity.jwakfu.net.packets.in;

import com.velocity.jwakfu.net.packets.IncomingPacket;
import com.velocity.jwakfu.net.packets.out.*;
import com.velocity.jwakfu.session.ClientSession;
import com.velocity.jwakfu.util.LoggingUtil;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;

public class Packet1213RedeemTicket implements IncomingPacket {

	private static final Logger logger = LoggingUtil.log();
	
	@Override
	public void decode(ClientSession session, ByteBuf buffer, int size) {
		byte[] data = new byte[buffer.readInt()];
		buffer.readBytes(data);
		String ticket = new String(data);

		logger.info("Ticket was redeemed: {}.", ticket);
		session.write(new Packet110SetIP());
		session.write(new Packet1025RealmLogin());
		session.write(new Packet1202CharListResponse(true));
		//session.write(new Packet2078FreeCompanionBreedId());
		session.write(new Packet2063ServerTime());
		//session.write(new Packet2067ShopInfo());
		//session.write(new Packet2069Unknown());
		//session.write(new Packet2077SendCompanions(null));
		//session.write(new Packet5255Unknown());
		session.write(new Packet2048DisplayCharacters());
	}

}
