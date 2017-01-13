package com.velocity.jwakfu.model;

public class Appearance {
	
	private int sex;
	private int skinColorIndex;
	private int hairColorIndex;
	private int pupilColorIndex;
	private int skinColorFactor;
	private int hairColorFactor;
	private int clothIndex;
	private int faceIndex;
	private int title;
	
	public Appearance(int sex, int skinColorIndex, int hairColorIndex, int pupilColorIndex, int skinColorFactor, int hairColorFactor, int clothIndex, int faceIndex, int title) {
		this.sex = sex;
		this.skinColorIndex = skinColorIndex;
		this.hairColorIndex = hairColorIndex;
		this.pupilColorIndex = pupilColorIndex;
		this.skinColorFactor = skinColorFactor;
		this.hairColorFactor = hairColorFactor;
		this.clothIndex = clothIndex;
		this.faceIndex = faceIndex;
		this.title = title;
	}
	
	public int getSex() {
		return sex;
	}
	
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public int getSkinColorIndex() {
		return skinColorIndex;
	}
	
	public void setSkinColorIndex(int skinColorIndex) {
		this.skinColorIndex = skinColorIndex;
	}
	
	public int getHairColorIndex() {
		return hairColorIndex;
	}
	
	public void setHairColorIndex(int hairColorIndex) {
		this.hairColorIndex = hairColorIndex;
	}
	
	public int getPupilColorIndex() {
		return pupilColorIndex;
	}
	
	public void setPupilColorIndex(int pupilColorIndex) {
		this.pupilColorIndex = pupilColorIndex;
	}
	
	public int getSkinColorFactor() {
		return skinColorFactor;
	}
	
	public void setSkinColorFactor(int skinColorFactor) {
		this.skinColorFactor = skinColorFactor;
	}
	
	public int getHairColorFactor() {
		return hairColorFactor;
	}
	
	public void setHairColorFactor(int hairColorFactor) {
		this.hairColorFactor = hairColorFactor;
	}
	
	public int getClothIndex() {
		return clothIndex;
	}
	
	public void setClothIndex(int clothIndex) {
		this.clothIndex = clothIndex;
	}
	
	public int getFaceIndex() {
		return faceIndex;
	}
	
	public void setFaceIndex(int faceIndex) {
		this.faceIndex = faceIndex;
	}
	
	public int getTitle() {
		return title;
	}
	
	public void setTitle(int title) {
		this.title = title;
	}

}
