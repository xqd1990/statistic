package com.club.statistic.service;

import java.util.List;

import com.club.statistic.entity.Organization;

public interface OrganizationService {
	public void save(Organization organization);
	public List<Organization> getOrganizations();
	public void delete(int id);
	public void modify(Organization organization);
}
