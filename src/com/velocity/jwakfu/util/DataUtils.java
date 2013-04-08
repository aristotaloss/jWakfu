package com.velocity.jwakfu.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DataUtils {
	
	public static final String readString(ByteBuf buf) {
		byte[] str = new byte[buf.readUnsignedByte()];
		buf.readBytes(str);
		return new String(str);
	}
	
	public static final ByteBuf bufferFromBytes(byte[] data) {
		ByteBuf buffer = Unpooled.buffer();
		buffer.writeBytes(data);
		buffer.markReaderIndex();
		buffer.markWriterIndex();
		buffer.resetReaderIndex();
		return buffer;
	}

}
