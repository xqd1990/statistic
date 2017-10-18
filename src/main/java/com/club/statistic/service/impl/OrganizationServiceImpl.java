package com.club.statistic.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.statistic.entity.Organization;
import com.club.statistic.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void save(Organization organization) {
		em.persist(organization);
	}

	@Override
	public List<Organization> getOrganizations() {
		return em.createQuery("select o from Organization o").getResultList();
	}

	@Override
	@Transactional
	public void delete(int id) {
		Organization organization = em.find(Organization.class, id);
		em.remove(organization);
	}

	@Override
	@Transactional
	public void modify(Organization organization) {
		// TODO Auto-generated method stub
		//System.out.println(em);
		em.merge(organization);
	}

}
