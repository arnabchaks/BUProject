package com.cg.gs.bean;

import java.util.Set;

public class Player {
	private String name;
	private Set<Game> gset;
	@Override
	public boolean equals(Object obj) {
		return name.equals(((Player)obj).name);
	}

	@Override
	public int hashCode() {
		return 1;
	}
	public Player(String name, Set<Game> gset) {
		super();
		this.name = name;
		this.gset = gset;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Game> getGset() {
		return gset;
	}

	public void setGset(Set<Game> gset) {
		this.gset = gset;
	}

	@Override
	public String toString() {
		return "Player: " + name + "\t Games played by player: " + gset;
	}
}