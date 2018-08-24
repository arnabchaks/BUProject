package com.cg.gs.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

		/*
		 * Set<Game> games = new HashSet<Game>(); games.add(new Game("Badminton"));
		 * games.add(new Game("Football")); HashSet<Day> days = new HashSet<Day>(); Day
		 * One = new Day("One", games); days.add(One); HashSet<Player> players = new
		 * HashSet<Player>(); Player Vinay = new Player("Vinay", games);
		 * players.add(Vinay); saveDay(new Day("One", games)); try { savePlayer(new
		 * Player("Arnab", games)); } catch (NotFoundException e) {
		 * System.err.println(e.getMessage()); } GameSummary gsumma = new
		 * GameSummary(new Game("Badminton"), days, players); gsum.put(new
		 * Game("Badminton"), gsumma); saveGame(new Game("Badminton")); saveGame(new
		 * Game("Football")); Map<Game, HashSet<Day>> pmap = new HashMap<Game,
		 * HashSet<Day>>(); pmap.put(new Game("Badminton"), days); PlayerSummary psumma
		 * = new PlayerSummary(new Player("Arnab", games), pmap); Map<Game,
		 * HashSet<Player>> dmap = new HashMap<Game, HashSet<Player>>(); dmap.put(new
		 * Game("Badminton"), players); DaySummary dsumma = new DaySummary(new
		 * Day("One", games), dmap); psum.put(Vinay, psumma); dsum.put(One, dsumma);
		 */

	}

	@Override
	public Player savePlayer(Player player) throws NotFoundException {
		PlayerSummary ps = new PlayerSummary();
		ps.setPlayer(player);
		for (Entry<Game, GameSummary> it : gsum.entrySet()) {
			for (Game g : player.getGset()) {
				if (it.getValue().getGame().equals(g)) {
					Map<Game, HashSet<Day>> pmap = new HashMap<Game, HashSet<Day>>();
					pmap.put(it.getKey(), it.getValue().getDset());
					ps.setPmap(pmap);
				} else {
					throw new NotFoundException("Game not found in the database.");
				}
			}

		}
		psum.put(player, ps);
		return player;
	}

	@Override
	public Game saveGame(Game game) {
		GameSummary gs = new GameSummary();
		gs.setGame(game);
		for (Entry<Player, PlayerSummary> it : psum.entrySet()) {
			for (Game g : it.getKey().getGset()) {
				if (g.getName().equals(game.getName())) {
					gs.getPset().add(it.getKey());
				}

			}
		}
		for (Entry<Day, DaySummary> it : dsum.entrySet()) {
			for (Game g : it.getKey().getGset()) {
				if (g.getName().equals(game.getName())) {
					gs.getDset().add(it.getKey());
				}
			}
		}
		gsum.put(game, gs);
		return game;
	}

	@Override
	public Day saveDay(Day day) {
		DaySummary ds = new DaySummary();
		ds.setDay(day);
		for (Entry<Game, GameSummary> it : gsum.entrySet()) {
			for (Game g : day.getGset()) {
				if (it.getValue().getGame().equals(g)) {
					Map<Game, HashSet<Player>> dmap = new HashMap<Game, HashSet<Player>>();
					dmap.put(it.getKey(), it.getValue().getPset());
					ds.setDmap(dmap);
				} else {
					saveGame(it.getValue().getGame());
				}
			}

		}
		dsum.put(day, ds);
		return day;
	}

	@Override
	public PlayerSummary getPlayerInfo(Player player) throws NotFoundException {
		for (Entry<Player, PlayerSummary> it : psum.entrySet()) {
			if (it.getKey().equals(player)) {
				return psum.get(player);
			} else {
				throw new NotFoundException("Player not found in database.");
			}

		}
		return null;

	}

	@Override
	public GameSummary getGameInfo(Game game) throws NotFoundException {
		for (Entry<Game, GameSummary> it : gsum.entrySet()) {
			if (it.getKey().equals(game)) {
				return gsum.get(game);
			} else {
				throw new NotFoundException("Game not found in database.");
			}

		}
		return null;
	}

	@Override
	public DaySummary getDayInfo(Day day) throws NotFoundException {
		for (Entry<Day, DaySummary> it : dsum.entrySet()) {
			if (it.getKey().equals(day)) {
				return dsum.get(day);
			} else {
				throw new NotFoundException("Day not found in database.");
			}

		}
		return null;
	}

}
