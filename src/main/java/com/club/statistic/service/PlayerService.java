package com.club.statistic.service;

import java.util.List;
import com.club.statistic.entity.Player;

public interface PlayerService {
	
	public void test();
	public int queryTotalPages();
	public List<Player> getPlayersByPage(int current_page);
	public Player getPlayerByAccount(String account);
	public Player getPlayerById(String id);
	public void addPlayer(Player player);
	public void updatePlayer(Player player);
	public void deletePlayer(String id);
}
