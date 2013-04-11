package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.model.GameCharacter;
import com.velocity.jwakfu.model.Player;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

public class Packet2048SendCharacters implements OutgoingPacket {

	private Player player;
	
	public Packet2048SendCharacters(Player player) {
		this.player = player;
	}
	
	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(2048);
		buffer.writeByte(player.getCharacters().size()); //amt of chars
		
		for (GameCharacter character : player.getCharacters()) {
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
			
			buffer.endMarkShort(0, -2);
		}
		return buffer;
	}

}
