package com.velocity.jwakfu.net.codec.binary;

import io.netty.buffer.ByteBuf;

/**
 * Created by Bart on 1/14/2017.
 */
public class IdCodec implements BinaryCodec<Long> {

	@Override
	public Long decode(ByteBuf buffer) {
		return buffer.readLong();
	}

	@Override
	public void encode(ByteBuf buffer, Long obj) {
		buffer.writeLong(obj);
	}

}
