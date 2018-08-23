package com.cg.gs.bean;

import java.util.HashSet;
import java.util.Map;

public class PlayerSummary {
	Player player;
	Map<Game, HashSet<Day>> pmap;
	public PlayerSummary(Player player, Map<Game, HashSet<Day>> pmap) {
		super();
		this.player = player;
		this.pmap = pmap;
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
		return "PlayerSummary [player=" + player + ", pmap=" + pmap + "]";
	}

}
