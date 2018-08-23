package com.cg.gs.dao;

import com.cg.gs.bean.Day;
import com.cg.gs.bean.DaySummary;
import com.cg.gs.bean.Game;
import com.cg.gs.bean.GameSummary;
import com.cg.gs.bean.Player;
import com.cg.gs.bean.PlayerSummary;

public interface GsDAO {
	public Player savePlayer(Player player);

	public Game saveGame(Game game);

	public Day saveDay(Day day);

	public PlayerSummary getPlayerInfo(Player player);

	public GameSummary getGameInfo(Game game);

	public DaySummary getDayInfo(Day day);
}
