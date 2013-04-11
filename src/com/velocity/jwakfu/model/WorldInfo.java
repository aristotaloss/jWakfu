package com.velocity.jwakfu.model;

import java.io.File;
import java.util.ArrayList;

import org.slf4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.velocity.jwakfu.util.LoggingUtil;

public class WorldInfo {

	private static Logger logger = LoggingUtil.log();
	private static ArrayList<WorldInfo> worlds = new ArrayList<WorldInfo>();
	
	private int id;
	private String name;
	
	@SuppressWarnings("unchecked")
	public static void loadWorlds(String file) {
		XStream xs = new XStream();
		xs.alias("worldinfo", WorldInfo.class);
		worlds = (ArrayList<WorldInfo>) xs.fromXML(new File(file));
		
		logger.info("Loaded information for " + worlds.size() + " worlds.");
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static WorldInfo getWorld(int id) {
		for (WorldInfo wi : worlds) {
			if (wi.getId() == id)
				return wi;
		}
		
		return null;
	}
	
	public static int getWorldCount() {
		return worlds.size();
	}
	
	public static ArrayList<WorldInfo> getList() {
		return worlds;
	}
	
}
