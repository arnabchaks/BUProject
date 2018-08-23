package com.cg.gs.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.cg.gs.bean.Day;
import com.cg.gs.bean.DaySummary;
import com.cg.gs.bean.Game;
import com.cg.gs.bean.GameSummary;
import com.cg.gs.bean.Player;
import com.cg.gs.bean.PlayerSummary;

public class GsDAOImpl implements GsDAO {

	public GsDAOImpl(){
		Set<Game> ArnabGame = new HashSet<Game>();
		ArnabGame.add(new Game("Badminton"));
		ArnabGame.add(new Game("Football"));
		Player ArnabC = new Player("Arnab", ArnabGame);
		Day Two = new Day("Two", ArnabGame);
		HashSet<Player> pl = new HashSet<Player>();
		pl.add(ArnabC);
		HashSet<Day> da = new HashSet<Day>();
		da.add(Two);
		Map<Game, HashSet<Player>> hm = new HashMap<Game, HashSet<Player>>();
		Map<Game, HashSet<Day>> hm1 = new HashMap<Game, HashSet<Day>>();
		hm.put(new Game("Badminton"), pl);
		hm1.put(new Game("Badminton"), da);
		DaySummary ds = new DaySummary(Two, hm);
		PlayerSummary ps = new PlayerSummary(ArnabC, hm1);
		psum.add(ps);
		dsum.add(ds);
	}
	HashSet<PlayerSummary> psum = new HashSet<PlayerSummary>();
	HashSet<GameSummary> gsum = new HashSet<GameSummary>();
	HashSet<DaySummary> dsum = new HashSet<DaySummary>();

	@Override
	public Player savePlayer(Player player) {
		Map<Game, HashSet<Day>> hm = new HashMap<Game, HashSet<Day>>();
		Iterator<Game> it = player.getGset().iterator();
		while (it.hasNext()) {
			hm.put(it.next(), null);
		}

		PlayerSummary ps = new PlayerSummary(player, hm);
		psum.add(ps);

		Iterator<PlayerSummary> psit = psum.iterator();
		Iterator<DaySummary> dsit = dsum.iterator();
		while (psit.hasNext() && dsit.hasNext()) {
			for (Game k : psit.next().getPmap().keySet()) {
				if (dsit.next().getDmap().keySet().contains(k)) {
					Map<Game, HashSet<Player>> hm1 = new HashMap<Game, HashSet<Player>>();
					HashSet<Player> hs = new HashSet<Player>();
					hs.add(player);
					hm1.put(k, hs);
					dsit.next().setDmap(hm1);
				}
			}
		}
		Iterator<GameSummary> gsit = gsum.iterator();
		while (gsit.hasNext()) {
			HashSet<Player> hs = new HashSet<Player>();
			hs.add(player);
			gsit.next().setPset(hs);

		}
		System.out.println(psum);
		System.out.println(dsum);
		return player;
	}

	@Override
	public Game saveGame(Game game) {
		GameSummary gs = new GameSummary(game, null, null);
		gsum.add(gs);
		System.out.println(psum);
		System.out.println(dsum);
		return game;
		
	}

	@Override
	public Day saveDay(Day day) {
		Map<Game, HashSet<Player>> hm = new HashMap<Game, HashSet<Player>>();
		Iterator<Game> it = day.getGset().iterator();
		while (it.hasNext()) {
			hm.put(it.next(), null);
		}
		DaySummary ds = new DaySummary(day, hm);
		dsum.add(ds);

		Iterator<PlayerSummary> psit = psum.iterator();
		Iterator<DaySummary> dsit = dsum.iterator();
		while (psit.hasNext() && dsit.hasNext()) {
			for (Game k : dsit.next().getDmap().keySet()) {
				if (psit.next().getPmap().keySet().contains(k)) {
					Map<Game, HashSet<Day>> hm1 = new HashMap<Game, HashSet<Day>>();
					HashSet<Day> hs = new HashSet<Day>();
					hs.add(day);
					hm1.put(k,hs);
					psit.next().setPmap(hm1);
				}
			}
		}
		Iterator<GameSummary> gsit = gsum.iterator();
		while (gsit.hasNext()) {
			HashSet<Day> hs = new HashSet<Day>();
			hs.add(day);
			gsit.next().setDset(hs);

		}
		System.out.println(psum);
		//System.out.println(dsum);
		return day;
	}

	@Override

	public PlayerSummary getPlayerInfo(Player player) {
		return null;
	}

	@Override
	public GameSummary getGameInfo(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaySummary getDayInfo(Day day) {
		// TODO Auto-generated method stub
		return null;
	}

}
