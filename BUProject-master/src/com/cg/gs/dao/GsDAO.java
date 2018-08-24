package com.cg.gs.dao;

import com.cg.gs.bean.Day;
import com.cg.gs.bean.DaySummary;
import com.cg.gs.bean.Game;
import com.cg.gs.bean.GameSummary;
import com.cg.gs.bean.Player;
import com.cg.gs.bean.PlayerSummary;
import com.cg.gs.exceptions.NotFoundException;

public interface GsDAO {
	public Player savePlayer(Player player);

	public Game saveGame(Game game);

	public Day saveDay(Day day);

	public PlayerSummary getPlayerInfo(Player player)throws NotFoundException;

	public GameSummary getGameInfo(Game game)throws NotFoundException;

	public DaySummary getDayInfo(Day day)throws NotFoundException;
}
