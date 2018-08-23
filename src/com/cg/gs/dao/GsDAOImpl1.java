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

public class GsDAOImpl1 implements GsDAO {
	HashMap<Integer, PlayerSummary> psum = new HashMap<Integer, PlayerSummary>();
	HashMap<Integer, GameSummary> gsum = new HashMap<Integer, GameSummary>();
	HashMap<Integer, DaySummary> dsum = new HashMap<Integer, DaySummary>();
	public GsDAOImpl1() {
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
		psum.put(i, ps);
		i++;
		dsum.put(i, ds);
	}
	
	static int i=0;
	@Override
	public Player savePlayer(Player player) {
		Map<Game, HashSet<Day>> hm = new HashMap<Game, HashSet<Day>>();
		Iterator<Game> it = player.getGset().iterator();
		while (it.hasNext()) {
			hm.put(it.next(), null);
		}

		PlayerSummary ps = new PlayerSummary(player, hm);
		i++;
		psum.put(i, ps);

		for(Game k : psum.get(i).getPmap().keySet()) {
			
			
			for(int j = 1; j<i; j++) {
				System.out.println(dsum);
				System.out.println(dsum.get(j)+ "....");
				if(dsum.get(j).getDmap().containsKey(k)) {
					HashSet<Player> pl= new HashSet<Player>();
					pl.add(player);
					dsum.get(j).getDmap().put(k, pl);
				}
				else {
					System.out.println("boo");
				}
			}
		}
		
/*		Iterator<GameSummary> gsit = gsum.iterator();
		while (gsit.hasNext()) {
			HashSet<Player> hs = new HashSet<Player>();
			hs.add(player);
			gsit.next().setPset(hs);

		}*/
		System.out.println(psum);
		System.out.println(dsum);
		return player;
	}

	@Override
	public Game saveGame(Game game) {
		GameSummary gs = new GameSummary(game, null, null);
		i++;
		gsum.put(i, gs);
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
		i++;
		dsum.put(i,ds);

		for(Game k : dsum.get(i).getDmap().keySet()) {
			for(int j = 1; j<i;j++) {
				if(psum.get(j).getPmap().containsKey(k)) {
					HashSet<Day> da= new HashSet<Day>();
					da.add(day);
					psum.get(j).getPmap().put(k, da);
				}
			}
		}
		/*Iterator<GameSummary> gsit = gsum.iterator();
		while (gsit.hasNext()) {
			HashSet<Day> hs = new HashSet<Day>();
			hs.add(day);
			gsit.next().setDset(hs);

		}*/
		System.out.println(psum);
		System.out.println(dsum);
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
