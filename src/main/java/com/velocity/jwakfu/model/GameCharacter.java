package com.velocity.jwakfu.model;

import com.velocity.jwakfu.io.OutPacket;

public class GameCharacter {
	
	private long id;
	private int idType;
	private long owner;
	private Breed breed;
	private Appearance appearance;
	private long xp;
	private Nation nation;
	private String name;
	
	public GameCharacter(String name, long id, int idType, long owner, Breed breed, long xp, Nation nation, Appearance appearance) {
		this.name = name;
		this.id = id;
		this.idType = idType;
		this.owner = owner;
		this.breed = breed;
		this.xp = xp;
		this.nation = nation;
		this.appearance = appearance;
	}
	
	public String getName() {
		return name;
	}
	
	public long getId() {
		return id;
	}
	
	public int getIdType() {
		return idType;
	}
	
	public long getOwner() {
		return owner;
	}
	
	public Breed getBreed() {
		return breed;
	}
	
	public long getXP() {
		return xp;
	}
	
	public Nation getNation() {
		return nation;
	}
	
	public void writeID(OutPacket buffer) {
		buffer.writeLong(id);
	}
	
	public void writeIdentity(OutPacket buffer) {
		buffer.writeByte(idType);
		buffer.writeLong(owner);
	}
	
	public void writeName(OutPacket buffer) {
		buffer.writeBigString(name);
	}
	
	public void writeBreed(OutPacket buffer) {
		buffer.writeShort(breed.ordinal() + 1);
	}
	
	public void writeAppearance(OutPacket buffer) {
		buffer.writeByte(appearance.getSex()); //Sex
		buffer.writeByte(appearance.getSkinColorIndex()); //skinColorIndex
		buffer.writeByte(appearance.getHairColorIndex()); //hairColorIndex
		buffer.writeByte(appearance.getPupilColorIndex()); //pupilColorIndex
		buffer.writeByte(appearance.getSkinColorFactor()); //skinColorFactor
		buffer.writeByte(appearance.getHairColorFactor()); //hairColorFactor
		buffer.writeByte(appearance.getClothIndex()); //clothIndex
		buffer.writeByte(appearance.getFaceIndex()); //faceIndex
		buffer.writeShort(appearance.getTitle()); //title
	}
	
	public void writeEquipment(OutPacket buffer) {
		buffer.writeByte(1); //amt of equips
		
		buffer.writeByte(22); //slot
		buffer.writeInt(12237);
	}
	
	public void writeCreationData(OutPacket buffer) {
		buffer.writeByte(0); //no creation data
	}
	
	public void writeXP(OutPacket buffer) {
		buffer.writeLong(xp*23);
		buffer.writeShort(0); //free points
		
		int[] points = new int[] {40, 37, 39, 36, 41, 38};
		buffer.writeShort(6);
		for (int i=0; i<points.length; i++) {
			buffer.writeByte(points[i]);
			buffer.writeShort(0);
		}
		
		buffer.writeShort(6); //characteristicBonusPointCount
		for (int i=0; i<points.length; i++) {
			buffer.writeByte(points[i]);
			buffer.writeShort(0);
		}
		
		buffer.writeInt(0); //gauge
	}
	
	public void writeNation(OutPacket buffer) {
		buffer.writeInt(nation.getId());
	}

}
