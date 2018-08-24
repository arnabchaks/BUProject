package com.cg.gs.ui;

import java.util.HashSet;
import java.util.Set;


import com.cg.gs.bean.Day;
import com.cg.gs.bean.Game;
import com.cg.gs.bean.Player;
import com.cg.gs.dao.GsDAO;
import com.cg.gs.dao.GsDAOImp;
import com.cg.gs.exceptions.NotFoundException;
import com.cg.gs.service.GsService;
import com.cg.gs.service.GsServiceImpl;

public class Client {

	public static void main(String[] args) {
		GsDAO gsd  = new GsDAOImp();
		GsService gss = new GsServiceImpl();
		gss.setGsd(gsd);
		System.out.println("****Menu**** \n 1. Add player \n");
		
		
		
		
		
		
		
		
		Set<Game> games = new HashSet<Game>();
		//Game Football = new Game("Football");
		//games.add(Football);
		//Player Vinay = new Player("Vinay", games);
		/*try {
			System.out.println(gss.getGameInfo(Football));
			System.out.println(gss.getPlayerInfo(Vinay));
		} catch (NotFoundException e) {
			System.err.println(e.getMessage());
		}*/
		Game Badminton = new Game("Badminton");
		//games.remove(Football);
		games.add(Badminton);
		Game Cricket = new Game("Cricket");
		games.add(Cricket);
		//System.out.println(gss.addGame(Badminton));
		Day Two = new Day("Two", games);
		Player Arnab = new Player("Arnab", games);
		//Player Pranjal = new Player("Pranjal", games);
		System.out.println(gss.addDay(Two));
		System.out.println(gss.addPlayer(Arnab));
		
		try {
			System.out.println(gss.getPlayerInfo(Arnab));
		} catch (NotFoundException e) {
			System.err.println(e.getMessage());
		}
		try {
			
			System.out.println(gss.getGameInfo(Badminton));
		} catch (NotFoundException e) {
			System.err.println(e.getMessage());
		}
		try {
			
			System.out.println(gss.getDayInfo(Two));
		} catch (NotFoundException e) {
			System.err.println(e.getMessage());
		}
		
//		System.out.println(gss.addGame(new Game("Badminton")));
//		System.out.println(gss.addGame(new Game("Football")));
//		Set<Game> games = new HashSet<Game>();
//		Game Badminton = new Game("Badminton");
//		games.add(Badminton);
//		games.add(new Game("Football"));
//		try {
//			System.out.println(gss.addPlayer(new Player("Arnab", games)));
//		} catch (NotFoundException e) {
//			
//		}
//		try {
//			System.out.println(gss.getGameInfo(new Game("Cricket")));
//		} catch (NotFoundException e) {
//			System.err.println(e.getMessage());
//		}
}
}