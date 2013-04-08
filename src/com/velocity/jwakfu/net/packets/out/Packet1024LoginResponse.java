package com.velocity.jwakfu.net.packets.out;

import com.velocity.jwakfu.io.OutPacket;
import com.velocity.jwakfu.net.packets.OutgoingPacket;
import com.velocity.jwakfu.net.packets.out.enums.LoginResponseCode;
import com.velocity.jwakfu.util.DataUtils;

public class Packet1024LoginResponse implements OutgoingPacket {

	private static final int PACKET_ID = 1024;
	
	private LoginResponseCode responseCode;
	private long charId;
	private long expirationDate;
	private boolean isAdmin;
	private String characterName;
	
	public Packet1024LoginResponse(LoginResponseCode responseCode) {
		this.responseCode = responseCode;
	}
	
	public Packet1024LoginResponse(String characterName, long charId, long expirationDate, boolean isAdmin) {
		this.responseCode = LoginResponseCode.CORRECT_LOGIN;
		this.characterName = characterName;
		this.charId = charId;
		this.expirationDate = expirationDate;
		this.isAdmin = isAdmin;
	}
	
	@Override
	public OutPacket encode() {
		OutPacket buffer = new OutPacket(PACKET_ID);
		buffer.writeByte(responseCode.getCode());
		
		if (responseCode == LoginResponseCode.CORRECT_LOGIN) {
			buffer.writeShort(50); //Size
			buffer.writeByte(1); //block count
			
			{
				buffer.writeByte(0); //Block id
				buffer.writeInt(6); //Block offset
				buffer.writeByte(0); //Ignored byte
				
				buffer.writeLong(charId);
				buffer.writeByte(0);
				buffer.writeLong(expirationDate);
				buffer.writeInt(isAdmin ? 1 : 0);
				
				DataUtils.writeString(buffer.getData(), characterName);
				DataUtils.writeString(buffer.getData(), "??");
				
				buffer.writeShort(0); //Has to do with additional data. See packet dissection of #1024.
			}
		}
		
		return buffer;
	}

}
