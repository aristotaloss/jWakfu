package com.velocity.jwakfu.net.codec;

import com.velocity.jwakfu.net.packets.in.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.HashMap;

import org.slf4j.Logger;

import com.velocity.jwakfu.net.GameServerHandler;
import com.velocity.jwakfu.net.packets.IncomingPacket;
import com.velocity.jwakfu.session.ClientSession;
import com.velocity.jwakfu.util.LoggingUtil;

@Sharable
public class PacketDecoder extends MessageToMessageDecoder<ByteBuf, ByteBuf> {

	private static final Logger logger = LoggingUtil.log();
	private static final HashMap<Integer, IncomingPacket> INCOMING_PACKET_MAP = new HashMap<Integer, IncomingPacket>();
	
	public PacketDecoder() {
		super(ByteBuf.class);
	}

	@Override
	public ByteBuf decode(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		ClientSession sess = ctx.channel().attr(GameServerHandler.CLIENTSESS_ATTR).get();
		if (sess != null && msg.readableBytes() > 0) {
			int size = msg.readUnsignedShort();
			int type = msg.readByte();
			int opcode = msg.readUnsignedShort();
			
			if (INCOMING_PACKET_MAP.containsKey(opcode)) {
				logger.info("Incoming packet. Size: " + size + ", Type: " + type + ", Opcode: " + opcode);
				INCOMING_PACKET_MAP.get(opcode).decode(sess, msg, size);
			} else {
				logger.warn("Unknown packet. Size: " + size + ", Type: " + type + ", Opcode: " + opcode);
			}
		}
		
		return msg;
	}
	
	private static void initPacketList() {
		INCOMING_PACKET_MAP.put(7, new Packet7Version());
		INCOMING_PACKET_MAP.put(1211, new Packet1211RequestTicket());
		INCOMING_PACKET_MAP.put(1213, new Packet1213RedeemTicket());
		INCOMING_PACKET_MAP.put(1026, new Packet1025Login());
		INCOMING_PACKET_MAP.put(1035, new Packet1035RefreshWorlds());
		INCOMING_PACKET_MAP.put(1201, new Packet1201ListCharacters());
		INCOMING_PACKET_MAP.put(2051, new Packet2051DeleteCharacter());
		INCOMING_PACKET_MAP.put(2053, new Packet2053CreateCharacter());
		INCOMING_PACKET_MAP.put(2055, new Packet2055LeaveCharacterScreen());
	}
	
	static {
		initPacketList();
	}
	
}