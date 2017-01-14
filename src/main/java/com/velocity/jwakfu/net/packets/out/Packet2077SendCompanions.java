package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.model.GameCharacter;
import com.velocity.jwakfu.model.Player;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

import java.math.BigInteger;

public class Packet2077SendCompanions implements OutgoingPacket {

	private Player player;

	public Packet2077SendCompanions(Player player) {
		this.player = player;
	}

	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(2077);

		buffer.writeBytes(new BigInteger("01000000000014af3a0b0d0000000006c24afa000000000000000000000000000000000000000000009959d20000000814880000000000081487000000000005080000", 16).toByteArray());
		//buffer.writeByte(0/*player.getCharacters().size()*/); //amt of chars

		/*for (GameCharacter character : player.getCharacters()) {
			buffer.markShort(0);
			buffer.writeByte(4); //block type

			character.writeID(buffer);
			character.writeIdentity(buffer);
			character.writeName(buffer);
			character.writeBreed(buffer);
			character.writeAppearance(buffer);
			character.writeEquipment(buffer);
			character.writeCreationData(buffer);
			character.writeXP(buffer);
			character.writeNation(buffer);

			buffer.endMarkShort(0);
		}*/
		return buffer;
	}

}