package com.velocity.jwakfu.net.packets.in;

import org.slf4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import com.velocity.jwakfu.crypto.RSACertificateManager;
import com.velocity.jwakfu.net.packets.IncomingPacket;
import com.velocity.jwakfu.net.packets.out.Packet1032RSAKey;
import com.velocity.jwakfu.net.packets.out.Packet1024LoginResponse;
import com.velocity.jwakfu.net.packets.out.enums.LoginResponseCode;
import com.velocity.jwakfu.session.ClientSession;
import com.velocity.jwakfu.util.DataUtils;
import com.velocity.jwakfu.util.LoggingUtil;

public class Packet1025Login implements IncomingPacket {
	
	private static final Logger logger = LoggingUtil.log();

	@Override
	public void decode(ClientSession session, ByteBuf buffer, int size) {
		byte[] b = new byte[size - 5]; // - 5 is due to the fact that the size includes the type/opcode/size bytes.
		buffer.readBytes(b);
		
		byte[] decoded = RSACertificateManager.INSTANCE.decode(b);
		ByteBuf decbuffer = DataUtils.bufferFromBytes(decoded);
		
		long rsaVerification = decbuffer.readLong();
		String username = DataUtils.readString(decbuffer);
		String password = DataUtils.readString(decbuffer);
		
		if (rsaVerification != Packet1032RSAKey.RSA_VERIFICATION_LONG) {
			logger.error("Error decoding RSA data: invalid verification long!");
			return;
		}
		
		logger.info("Login packet: " + username + ", " + password);
		session.getChannel().write(new Packet1024LoginResponse(LoginResponseCode.ACCOUNT_UNDER_MODERATION).encode());
	}

}
