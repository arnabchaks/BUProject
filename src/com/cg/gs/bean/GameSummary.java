package com.cg.gs.bean;

import java.util.HashSet;
import java.util.Set;

public class GameSummary {
	Game game;
	HashSet<Day> dset;
	HashSet<Player> pset;

	public GameSummary(Game game, HashSet<Day> dset, HashSet<Player> pset) {
		super();
		this.game = game;
		this.dset = dset;
		this.pset = pset;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Set<Day> getDset() {
		return dset;
	}

	public void setDset(HashSet<Day> dset) {
		this.dset = dset;
	}

	public Set<Player> getPset() {
		return pset;
	}

	public void setPset(HashSet<Player> pset) {
		this.pset = pset;
	}

	@Override
	public String toString() {
		return "GameSummary [game=" + game + ", dset=" + dset + ", pset=" + pset + "]";
	}

}
