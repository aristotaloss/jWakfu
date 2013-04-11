package com.velocity.jwakfu.model;

public enum Nation {
	
	NONE(0), AMAKNA(30), BONTA(31), BRAKMAR(32), SUFOKIA(33);
	
	private int id;
	
	private Nation(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

}
