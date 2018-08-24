package com.cg.gs.ui;

import java.util.HashSet;
import java.util.Set;

import com.cg.gs.bean.Game;
import com.cg.gs.bean.Player;
import com.cg.gs.exceptions.NotFoundException;
import com.cg.gs.service.GsService;
import com.cg.gs.service.GsServiceImpl;

public class Test {

	public static void main(String[] args) {
		System.out.println("Print plz");
		GsService gss = new GsServiceImpl();
		System.out.println(gss.addGame(new Game("Badminton")));
		System.out.println(gss.addGame(new Game("Football")));
		Set<Game> games = new HashSet<Game>();
		Game Badminton = new Game("Badminton");
		games.add(Badminton);
		games.add(new Game("Football"));
		try {
			System.out.println(gss.addPlayer(new Player("Arnab", games)));
		} catch (NotFoundException e) {
			
		}
		try {
			System.out.println(gss.getGameInfo(new Game("Cricket")));
		} catch (NotFoundException e) {
			System.err.println(e.getMessage());
		}
}
}