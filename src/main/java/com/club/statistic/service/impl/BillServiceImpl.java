package com.club.statistic.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.statistic.entity.Bill;
import com.club.statistic.service.BillService;

@Service
public class BillServiceImpl implements BillService{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void billIn(List<Bill> bills) {
		// TODO Auto-generated method stub
		for(Bill bill:bills){
			em.persist(bill);
		}
	}

	@Override
	public List<Bill> getBills(String start, String end) {
		Query query = em.createQuery("select b from Bill b where b.finish_time>=:start and b.finish_time<=:end");
		query.setParameter("start", start);
		query.setParameter("end", end);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void billPay(String[] array) {
		// TODO Auto-generated method stub
		for(int i=0;i<array.length;i++){
			Bill bill = em.find(Bill.class, Integer.valueOf(array[i]));
			bill.setServer_state(1);
			em.merge(bill);
		}
	}

	@Override
	@Transactional
	public void billCancel(String[] array) {
		// TODO Auto-generated method stub
		for(int i=0;i<array.length;i++){
			Bill bill = em.find(Bill.class, Integer.valueOf(array[i]));
			bill.setServer_state(0);
			em.merge(bill);
		}
	}
}
