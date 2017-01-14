package com.velocity.jwakfu.net.codec.binary;

import io.netty.buffer.ByteBuf;

/**
 * Created by Bart on 1/14/2017.
 */
public interface BinaryCodec<T> {

	public T decode(ByteBuf buffer);

	public void encode(ByteBuf buffer, T obj);

}
