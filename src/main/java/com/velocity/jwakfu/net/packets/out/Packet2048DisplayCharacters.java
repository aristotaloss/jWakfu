package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.model.GameCharacter;
import com.velocity.jwakfu.model.Player;
import com.velocity.jwakfu.net.packets.OutgoingPacket;

/**
 * Created by Bart on 1/14/2017.
 */
public class Packet2048DisplayCharacters implements OutgoingPacket {

	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(2048);

		buffer.writeByte(1);

		Player player = Player.load("velocity");
		for (GameCharacter character : player.getCharacters()) {
			buffer.markShort(0);
			buffer.writeByte(4); //block type

			/*FOR_CHARACTER_LIST = new CharacterDeserializationGroup("FOR_CHARACTER_LIST", 4,
					new CharacterPartType[]{
						CharacterPartType.ID,
							CharacterPartType.IDENTITY,
							CharacterPartType.NAME,
							CharacterPartType.BREED,
							CharacterPartType.ACTIVE_EQUIPMENT_SHEET,
							CharacterPartType.APPEARANCE,
							CharacterPartType.EQUIPMENT_APPEARANCE,
							CharacterPartType.CREATION_DATA,
							CharacterPartType.XP,
							CharacterPartType.CHARACTER_LIST_NATION_ID,
							CharacterPartType.GUILD_ID,
							CharacterPartType.GUILD_BLAZON,
							CharacterPartType.INSTANCE_ID});*/

			character.writeID(buffer);
			character.writeIdentity(buffer);
			character.writeName(buffer);
			character.writeBreed(buffer);
			character.writeActiveEquipmentSheet(buffer);
			character.writeAppearance(buffer);
			character.writeEquipment(buffer);
			character.writeCreationData(buffer);
			character.writeXP(buffer);
			character.writeNation(buffer);
			character.writeGuildId(buffer);
			character.writeGuildBlazon(buffer);
			character.writeInstanceId(buffer);

			buffer.endMarkShort(0);
		}

		// blocks of 2-byte-sized byte[]

		return buffer;
	}

}
