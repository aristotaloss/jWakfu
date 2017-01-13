package com.velocity.jwakfu.net.packets.in;

import com.velocity.jwakfu.net.packets.out.Packet8VersionAck;
import io.netty.buffer.ByteBuf;

import org.slf4j.Logger;

import com.velocity.jwakfu.net.packets.IncomingPacket;
import com.velocity.jwakfu.net.packets.out.Packet1032RSAKey;
import com.velocity.jwakfu.session.ClientSession;
import com.velocity.jwakfu.util.DataUtils;
import com.velocity.jwakfu.util.LoggingUtil;

public class Packet7Version implements IncomingPacket {
	
	private static final Logger logger = LoggingUtil.log();
	private static final String REQUIRED_BUILD_VERSION = "90414";

	@Override
	public void decode(ClientSession session, ByteBuf buffer, int size) {
		int major = buffer.readUnsignedByte();
		int minor = buffer.readUnsignedShort();
		int patch = buffer.readUnsignedByte();
		String buildVersion = DataUtils.readString(buffer);
		
		logger.info("Received version packet: {build={}.{}.{} ({})}", new Object[] {major, minor, patch, buildVersion});
		session.write(new Packet8VersionAck(true, major, minor, patch, buildVersion));
		session.write(new Packet1032RSAKey());
	}

}
