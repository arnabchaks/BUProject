package com.cg.gs.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import com.cg.gs.bean.Day;
import com.cg.gs.bean.DaySummary;
import com.cg.gs.bean.Game;
import com.cg.gs.bean.GameSummary;
import com.cg.gs.bean.Player;
import com.cg.gs.bean.PlayerSummary;
import com.cg.gs.exceptions.NotFoundException;

public class GsDAOImp implements GsDAO {
	Map<Player, PlayerSummary> psum = new HashMap<Player, PlayerSummary>();
	Map<Game, GameSummary> gsum = new HashMap<Game, GameSummary>();
	Map<Day, DaySummary> dsum = new HashMap<Day, DaySummary>();

	public GsDAOImp() {

		Game Football = new Game("Football");
		HashSet<Game> games = new HashSet<Game>();
		games.add(Football);
		Player Vinay = new Player("Vinay", games);
		HashSet<Player> players = new HashSet<Player>();
		players.add(Vinay);
		Day One = new Day("One", games);
		HashSet<Day> days = new HashSet<Day>();
		days.add(One);
		Map<Game, HashSet<Day>> pmp = new HashMap<Game, HashSet<Day>>();
		Map<Game, HashSet<Player>> dmp = new HashMap<Game, HashSet<Player>>();
		pmp.put(Football, days);
		PlayerSummary sump = new PlayerSummary(Vinay, pmp);
		dmp.put(Football, players);
		DaySummary sumd = new DaySummary(One, dmp);
		GameSummary sumg = new GameSummary(Football, days, players);
		psum.put(Vinay, sump);
		gsum.put(Football, sumg);
		dsum.put(One, sumd);

	}

	@Override
	public Player savePlayer(Player player) {
		PlayerSummary ps = new PlayerSummary();
		ps.setPlayer(player);
		boolean b = false;
		for (Entry<Game, GameSummary> it : gsum.entrySet()) {
			for (Game g : player.getGset()) {
				if (it.getValue().getGame().getName().equals(g.getName())) {
					Map<Game, HashSet<Day>> pmap = new HashMap<Game, HashSet<Day>>();
					pmap.put(it.getKey(), it.getValue().getDset());
					ps.setPmap(pmap);
					psum.put(player, ps);
					b = true;
				} else {
					psum.put(player, ps);
					b = false;

				}
			}

		}
		if (!b)
			for (Game ga : player.getGset())
				saveGame(ga);
		for (Entry<Day, DaySummary> it : dsum.entrySet()) {
			for (Game g : player.getGset()) {
				if (it.getKey().getGset().contains(g)) {
					Map<Game, HashSet<Player>> dmp = new HashMap<Game, HashSet<Player>>();
					HashSet<Player> temp = new HashSet<Player>();
					temp.add(player);
					dmp.put(g, temp);
					it.getValue().setDmap(dmp);
				}
			}
		}
		for (Entry<Game, GameSummary> it : gsum.entrySet()) {
			for (Game g : player.getGset()) {
				if (it.getKey().equals(g)) {
					HashSet<Player> temp = new HashSet<Player>();
					temp.add(player);
					it.getValue().setPset(temp);
				}
			}
		}
		return player;
	}

	@Override
	public Day saveDay(Day day) {
		DaySummary ds = new DaySummary();
		ds.setDay(day);
		Boolean b = false;
		for (Entry<Game, GameSummary> it : gsum.entrySet()) {
			for (Game g : day.getGset()) {
				if (it.getValue().getGame().getName().equals(g.getName())) {
					Map<Game, HashSet<Player>> dmap = new HashMap<Game, HashSet<Player>>();
					dmap.put(it.getKey(), it.getValue().getPset());
					ds.setDmap(dmap);
					dsum.put(day, ds);
					b = true;
				} else {
					dsum.put(day, ds);
					b = false;
				}
			}

		}
		if (!b)
			for (Game ga : day.getGset())
				saveGame(ga);
		for (Entry<Player, PlayerSummary> it : psum.entrySet()) {
			for (Game g : day.getGset()) {
				if (it.getKey().getGset().contains(g)) {
					Map<Game, HashSet<Day>> pmp = new HashMap<Game, HashSet<Day>>();
					HashSet<Day> temp = new HashSet<Day>();
					temp.add(day);
					pmp.put(g, temp);
					it.getValue().setPmap(pmp);
				}
			}
		}
		for (Entry<Game, GameSummary> it : gsum.entrySet()) {
			for (Game g : day.getGset()) {
				if (it.getKey().equals(g)) {
					HashSet<Day> temp = new HashSet<Day>();
					temp.add(day);
					it.getValue().setDset(temp);
				}
			}
		}
		return day;
	}

	@Override
	public Game saveGame(Game game) {
		GameSummary gs = new GameSummary(game, null, null);
		gsum.put(game, gs);
		return game;
	}

	@Override
	public PlayerSummary getPlayerInfo(Player player) throws NotFoundException {
		boolean b = false;
		for (Entry<Player, PlayerSummary> it : psum.entrySet()) {

			if (it.getKey().getName().equals(player.getName())) {
				b = true;
				return psum.get(player);

			} else {
				b = false;
			}

		}
		if (!b) {
			throw new NotFoundException("Player not found in database.");
		}
		return psum.get(player);
	}

	@Override
	public GameSummary getGameInfo(Game game) throws NotFoundException {

		boolean b = false;
		for (Entry<Game, GameSummary> it : gsum.entrySet()) {

			if (it.getKey().getName().equals(game.getName())) {
				b = true;
				return gsum.get(game);
			} else {
				b = false;
			}

		}
		if (!b) {
			throw new NotFoundException("Game not found in database.");
		}
		return gsum.get(game);
	}

	@Override
	public DaySummary getDayInfo(Day day) throws NotFoundException {
		boolean b = true;
		for (Entry<Day, DaySummary> it : dsum.entrySet()) {

			if (it.getKey().getName().equals(day.getName())) {
				b = true;
				return dsum.get(day);

			} else {
				b = false;
			}

		}
		if (!b) {
			throw new NotFoundException("Day not found in database.");
		}
		return dsum.get(day);
	}

}
