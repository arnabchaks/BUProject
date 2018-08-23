package com.cg.gs.ui;

import java.util.HashSet;
import java.util.Set;

import com.cg.gs.bean.Day;
import com.cg.gs.bean.Game;
import com.cg.gs.bean.Player;
import com.cg.gs.dao.GsDAO;
import com.cg.gs.dao.GsDAOImpl1;

public class Test {

	public static void main(String[] args) {
		System.out.println("Print plz");
		GsDAO gsd = new GsDAOImpl1();
		Set<Game> ArnabGame = new HashSet<Game>();
		ArnabGame.add(new Game("Badminton"));
		ArnabGame.add(new Game("Football"));
		
		Player Arnab = new Player("Arnab", ArnabGame);
		Day One = new Day("One", ArnabGame);
		gsd.savePlayer(Arnab);
		gsd.saveDay(One);
		
	}

}
