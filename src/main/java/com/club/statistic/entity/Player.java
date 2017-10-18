package com.club.statistic.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player {
	private String id;
	private String account;
	private double win_interest;
	private double lose_interest;
	private String mark;
	private Organization organization;
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="organization_id")
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	private Set<Bill> bills;
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY,mappedBy="player")
	@JsonIgnore
	public Set<Bill> getBills() {
		return bills;
	}
	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}
	@Id@Column(length=12)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
}
