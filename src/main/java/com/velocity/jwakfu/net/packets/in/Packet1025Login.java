package com.velocity.jwakfu.net.packets.in;

import io.netty.buffer.ByteBuf;

import java.io.File;

import org.slf4j.Logger;

import com.velocity.jwakfu.crypto.RSACertificateManager;
import com.velocity.jwakfu.model.Player;
import com.velocity.jwakfu.net.packets.IncomingPacket;
import com.velocity.jwakfu.net.packets.out.Packet1027LoginResponse;
import com.velocity.jwakfu.net.packets.out.Packet1032RSAKey;
import com.velocity.jwakfu.net.packets.out.Packet1200ListWorlds;
import com.velocity.jwakfu.net.packets.out.enums.LoginResponseCode;
import com.velocity.jwakfu.session.ClientSession;
import com.velocity.jwakfu.util.DataUtils;
import com.velocity.jwakfu.util.LoggingUtil;

public class Packet1025Login implements IncomingPacket {

	private static final Logger logger = LoggingUtil.log();

	@Override
	public void decode(ClientSession session, ByteBuf buffer, int size) {
		byte[] b = new byte[buffer.readInt()];
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
		
		if (!userExists(username)) {
			session.write(new Packet1027LoginResponse(LoginResponseCode.INVALID_LOGIN));
		} else {
			Player player = Player.load(username);
			if (player.getPassword().equals(password)) {
				session.write(new Packet1027LoginResponse(/*player.getName(), 33965798L, 0L, false*/LoginResponseCode.CORRECT_LOGIN)).write(new Packet1200ListWorlds());
				session.setPlayer(player);
			} else {
				session.write(new Packet1027LoginResponse(LoginResponseCode.INVALID_LOGIN));
			}
			player.save();
		}
	}
	
	private boolean userExists(String user) {
		return new File("data/chars/"+user+".xml").exists();
	}

}
