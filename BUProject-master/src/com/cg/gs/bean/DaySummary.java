package com.cg.gs.bean;

import java.util.HashSet;
import java.util.Map;

public class DaySummary {
	Day day;
	Map<Game, HashSet<Player>> dmap;

	public DaySummary(Day day, Map<Game, HashSet<Player>> dmap) {
		super();
		this.day = day;
		this.dmap = dmap;
	}

	public DaySummary() {
		// TODO Auto-generated constructor stub
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Map<Game, HashSet<Player>> getDmap() {
		return dmap;
	}

	public void setDmap(Map<Game, HashSet<Player>> dmap) {
		this.dmap = dmap;
	}

	@Override
	public String toString() {
		return "DaySummary [day=" + day + ", dmap=" + dmap + "]";
	}

}
