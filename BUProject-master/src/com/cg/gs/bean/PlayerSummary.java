package com.cg.gs.bean;

import java.util.HashSet;
import java.util.Map;

public class PlayerSummary {
	private Player player;
	private Map<Game, HashSet<Day>> pmap;
	public PlayerSummary(Player player, Map<Game, HashSet<Day>> pmap) {
		super();
		this.player = player;
		this.pmap = pmap;
	}

	public PlayerSummary() {
		// TODO Auto-generated constructor stub
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Map<Game, HashSet<Day>> getPmap() {
		return pmap;
	}

	public void setPmap(Map<Game, HashSet<Day>> pmap) {
		this.pmap = pmap;
	}

	@Override
	public String toString() {
		String s1 = null;
		for(Game k : player.getGset()) 
			s1 = player + "\t List of Days on which game(s) played: " +  pmap.get(k);
		return s1;

}
}