package com.velocity.jwakfu.io;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class OutPacket {
	
	private ByteBuf data;
	private int packetId;
	
	public OutPacket(int packetId) {
		data = Unpooled.buffer();
		data.writeShort(0); //Size placeholder
		data.writeShort(packetId);
	}
	
	public void finish() {
		data.setShort(0, data.writerIndex());
	}
	
	public ByteBuf getData() {
		return data;
	}
	
	public int getPacketId() {
		return packetId;
	}
	
	public OutPacket writeByte(int b) {
		data.writeByte(b);
		return this;
	}
	
	public OutPacket writeShort(int s) {
		data.writeShort(s);
		return this;
	}
	
	public OutPacket writeInt(int i) {
		data.writeInt(i);
		return this;
	}
	
	public OutPacket writeLong(long l) {
		data.writeLong(l);
		return this;
	}
	
	public OutPacket writeBytes(byte[] b) {
		data.writeBytes(b);
		return this;
	}
	
}
