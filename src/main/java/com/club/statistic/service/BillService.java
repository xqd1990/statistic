package com.club.statistic.service;

import java.util.List;

import com.club.statistic.entity.Bill;

public interface BillService {
	public void billIn(List<Bill> bills);
	public List<Bill> getBills(String start, String end);
	public void billPay(String[] array);
	public void billCancel(String[] array);
}
