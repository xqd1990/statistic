package com.club.statistic.controller;

import java.io.FileInputStream;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.club.statistic.entity.Organization;
import com.club.statistic.entity.Player;
import com.club.statistic.service.PlayerService;

@Controller
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/show")
	public String showPlayers(HttpServletRequest req, int current_page) {
		//playerService.test();
		req.setAttribute("total_page", playerService.queryTotalPages());
		req.setAttribute("current_page", current_page);
		req.setAttribute("players", playerService.getPlayersByPage(current_page));
		return "player";
	}
	
	@RequestMapping("/add")
	public String addPlayer(HttpServletRequest req, Player player){
		playerService.addPlayer(player);
		req.setAttribute("message", "添加成功");
		return "forward:/player/show";
	}
	
	@RequestMapping("/modify")
	public String modPlayer(HttpServletRequest req, Player player){
		playerService.updatePlayer(player);
		req.setAttribute("message", "修改成功");
		return "forward:/player/show";
	}
	
	@RequestMapping("/delete")
	public String deletePlayer(HttpServletRequest req, String id){
		playerService.deletePlayer(id);
		req.setAttribute("message", "删除成功");
		return "forward:/player/show";
	}
	
	@RequestMapping("/queryById")
	public @ResponseBody Player getPlayerById(String id){
		return playerService.getPlayerById(id);
	}
	
	@RequestMapping("/queryByAccount")
	public @ResponseBody Player getPlayerByAccount(String account){
		return playerService.getPlayerByAccount(account);
	}
}
