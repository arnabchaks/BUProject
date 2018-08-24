package com.cg.gs.bean;

import java.util.Set;

public class Day {
	String name;
	Set<Game> gset;

	public Day(String name, Set<Game> gset) {
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
		return "Day [name=" + name + ", gset=" + gset + "]";
	}

}