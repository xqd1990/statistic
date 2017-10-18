package com.club.statistic.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Organization {
	private Integer id;
	private String name;
	private int insurance;
	private double win_interest;
	private double lose_interest;
	private String manager;
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	private String mark;
	private Set<Player> players;
	@Id@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInsurance() {
		return insurance;
	}
	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}
	public double getWin_interest() {
		return win_interest;
	}
	public void setWin_interest(double win_interest) {
		this.win_interest = win_interest;
	}
	public double getLose_interest() {
		return lose_interest;
	}
	public void setLose_interest(double lose_interest) {
		this.lose_interest = lose_interest;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY,mappedBy="organization")
	@JsonIgnore
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
}
