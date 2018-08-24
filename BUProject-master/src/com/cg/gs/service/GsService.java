package com.cg.gs.service;

import com.cg.gs.bean.Day;
import com.cg.gs.bean.DaySummary;
import com.cg.gs.bean.Game;
import com.cg.gs.bean.GameSummary;
import com.cg.gs.bean.Player;
import com.cg.gs.bean.PlayerSummary;
import com.cg.gs.dao.GsDAO;
import com.cg.gs.exceptions.NotFoundException;
import com.cg.gs.exceptions.WrongInputException;

public interface GsService {
	public Player addPlayer(Player player);

	public Game addGame(Game game);

	public Day addDay(Day day);

	public PlayerSummary getPlayerInfo(Player player)throws NotFoundException;

	public GameSummary getGameInfo(Game game)throws NotFoundException;

	public DaySummary getDayInfo(Day day) throws NotFoundException;
	
	public Boolean validateInput(String s) throws WrongInputException;

	public void setGsd(GsDAO gsd);
}
