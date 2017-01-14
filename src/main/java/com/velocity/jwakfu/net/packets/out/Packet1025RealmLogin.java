package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

/**
 * Created by Bart on 1/14/2017.
 */
public class Packet1025RealmLogin implements OutgoingPacket {

	@Override
	public OutPacket encode() {
		OutPacket out = new OutPacket(1025);
		out.writeByte(0); // Response code

		// short-marked byte array of data!!!
		out.markShort(0);

		out.writeByte(1); // Part count
		{
			out.writeByte(0); // Part ID
			out.writeInt(6); // Part offset
			out.writeByte(0); // Padding..?

			/* Struct AccountInformations */
			{
				out.writeLong(113396474); // Account ID
				out.writeInt(104); // Subscription level
				out.writeInt(0); // Addiction level
				out.writeByte(0); // Unknown
				out.writeLong(1484839884000L); // Expiry long
				out.writeInt(1); // Hero subscription count
				{
					out.writeInt(0); // ?
					out.writeLong(0); // ?
				}

				// Admin rights - all 0 for now
				for (int i=0; i<100; i++) {
					out.writeInt(0); // Value
				}

				out.writeString("codermen"); // Nickname
				out.writeInt(7); // Community
				out.writeShort(0); // Length of an unidentified data block.
			}
		}

		out.endMarkShort(0);
		return out;
	}
}
