package com.club.statistic.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import com.club.statistic.entity.Organization;
import com.club.statistic.entity.Player;
import com.club.statistic.entity.SharedData;
import com.club.statistic.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void test() {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:/excel/test.xls");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WorkbookSettings setting  =new WorkbookSettings();
		setting.setEncoding("utf-8");
		Workbook wb = null;
		try {
			wb = Workbook.getWorkbook(fis,setting);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(0);
		int count = sheet.getRows();
		Query query = em.createQuery("select o from Organization o where o.name=:name");
		for(int i=1;i<count;i++){
			Player player = new Player();
			player.setId(sheet.getCell(0,i).getContents());
			player.setAccount(sheet.getCell(1,i).getContents());
			if("".equals(sheet.getCell(2,i).getContents().trim()))
				query.setParameter("name","默认");
			else
				query.setParameter("name",sheet.getCell(2,i).getContents());
			List<Organization> organizations = query.getResultList();
			if(organizations.size()==0)
				query.setParameter("name", "默认");
			organizations = query.getResultList();
			player.setOrganization(organizations.get(0));
			if(!"".equals(sheet.getCell(3,i).getContents()))
				player.setWin_interest(Double.valueOf(sheet.getCell(3,i).getContents()));
			if(!"".equals(sheet.getCell(4,i).getContents()))
				player.setLose_interest(Double.valueOf(sheet.getCell(4,i).getContents()));
			em.persist(player);
			if(i%30==0){
				em.flush();
				em.clear();
			}
		}
	}

	@Override
	public int queryTotalPages() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select count(*) from Player p");
		return Integer.valueOf(query.getResultList().get(0).toString())/SharedData.COUNT+1;
	}

	@Override
	public List<Player> getPlayersByPage(int current_page) {
		Query query = em.createQuery("select p from Player p order by p.organization.id");
		query.setFirstResult((current_page-1)*SharedData.COUNT);
		query.setMaxResults(SharedData.COUNT);
		List<Player> players = query.getResultList();
		return players;
	}

	@Override
	public Player getPlayerByAccount(String account) {
		Query query = em.createQuery("select p from Player p where p.account=:account");
		query.setParameter("account", account);
		return (Player) query.getResultList().get(0);
	}

	@Override
	public Player getPlayerById(String id) {
		// TODO Auto-generated method stub
		return em.find(Player.class, id);
	}

	@Override
	@Transactional
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select o from Organization o where o.name=:name");
		query.setParameter("name", player.getOrganization().getName());
		Organization o = (Organization) query.getResultList().get(0);
		player.setOrganization(o);
		em.persist(player);
	}

	@Override
	@Transactional
	public void updatePlayer(Player player) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select o from Organization o where o.name=:name");
		query.setParameter("name", player.getOrganization().getName());
		Organization o = (Organization) query.getResultList().get(0);
		player.setOrganization(o);
		em.merge(player);
	}

	@Override
	@Transactional
	public void deletePlayer(String id) {
		// TODO Auto-generated method stub
		em.remove(getPlayerById(id));
	}

}
