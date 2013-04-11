package com.velocity.jwakfu.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.MarshallingStrategy;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.enums.EnumConverter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.velocity.jwakfu.net.packets.out.enums.LoginResponseCode;

public class Player {
	
	private String name;
	private String displayName;
	private String password;
	private ArrayList<GameCharacter> characters = new ArrayList<GameCharacter>();
	
	public Player(String name, String displayName, String password) {
		this.name = name;
		this.displayName = displayName;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void addCharacter(GameCharacter character) {
		characters.add(character);
	}
	
	public ArrayList<GameCharacter> getCharacters() {
		return characters;
	}
	
	public void save() {
		File f = new File("data/chars/"+name+".xml");
		
		XStream xs = new XStream();
		xs.registerConverter(new EnumConverter());
		
		xs.alias("player", Player.class);
		xs.alias("breed", Breed.class);
		xs.alias("character", GameCharacter.class);
		xs.alias("nation", Nation.class);
		xs.alias("appearance", Appearance.class);
		
		try {
			xs.toXML(this, new FileOutputStream(f));
			System.out.println(xs.toXML(this));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Player load(String name) {
		File f = new File("data/chars/"+name+".xml");
		if (!f.exists())
			return null;
		
		XStream xs = new XStream();
		xs.alias("player", Player.class);
		xs.alias("breed", Breed.class);
		xs.alias("character", GameCharacter.class);
		xs.alias("nation", Nation.class);
		xs.alias("appearance", Appearance.class);
		return (Player) xs.fromXML(f);
	}
	
}
