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

public class GsServiceImpl implements GsService {
	private GsDAO gsd;
	public GsServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setGsd(GsDAO gsd) {
		this.gsd = gsd;
	}

	@Override
	public Player addPlayer(Player player) {
		return gsd.savePlayer(player);
	}

	@Override
	public Game addGame(Game game) {
		return gsd.saveGame(game);
	}

	@Override
	public Day addDay(Day day) {
		return gsd.saveDay(day);
	}

	@Override
	public PlayerSummary getPlayerInfo(Player player) throws NotFoundException {
		return gsd.getPlayerInfo(player);
	}

	@Override
	public GameSummary getGameInfo(Game game) throws NotFoundException {
		return gsd.getGameInfo(game);
	}

	@Override
	public DaySummary getDayInfo(Day day) throws NotFoundException {
		return gsd.getDayInfo(day);
	}

	@Override
	public Boolean validateInput(String s) throws WrongInputException {
		if(!s.matches("[A-Za-z]{0-50}"))
			throw new WrongInputException("Please enter an alphabetical value of player name, game name and day name.");
			else
				return true;
	}

}
