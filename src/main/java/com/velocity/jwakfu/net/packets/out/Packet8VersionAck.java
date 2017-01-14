package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

/**
 * Created by Bart on 1/14/2017.
 */
public class Packet8VersionAck implements OutgoingPacket {

	private boolean accepted;
	private int major;
	private int minor;
	private int patch;
	private String release;

	public Packet8VersionAck(boolean accepted, int major, int minor, int patch, String release) {
		this.accepted = accepted;
		this.major = major;
		this.minor = minor;
		this.patch = patch;
		this.release = release;
	}

	@Override
	public OutPacket encode() {
		OutPacket out = new OutPacket(8);
		out.writeByte(accepted ? 1 : 0); // Version OK

		out.writeByte(major);
		out.writeShort(minor);
		out.writeByte(patch);
		out.writeString(release);

		return out;
	}
}
