package com.cg.gs.bean;

public class Game {
	private String name;

	
	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return name.equals(((Game)obj).name);
	}
	
	public Game(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Game: " + name;
	}

}
