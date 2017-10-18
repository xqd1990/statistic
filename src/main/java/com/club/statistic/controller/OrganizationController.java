package com.club.statistic.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.statistic.entity.Organization;
import com.club.statistic.service.OrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping("/show")
	public String showOrganizations(HttpServletRequest req){
		req.setAttribute("organizations",organizationService.getOrganizations());
		return "organization";
	}
	@RequestMapping("/add")
	public String addOrganization(HttpServletRequest req, Organization organization){
		organizationService.save(organization);
		req.setAttribute("message","添加成功");
		return "forward:/organization/show";
	}
	@RequestMapping("/delete")
	public String deleteOrganization(HttpServletRequest req, Integer id){
		organizationService.delete(id);
		req.setAttribute("message","删除成功");
		return "forward:/organization/show";
	}
	@RequestMapping("/modify")
	public String modifyOrganization(HttpServletRequest req, Organization organization){
		organizationService.modify(organization);
		req.setAttribute("message","修改成功");
		return "forward:/organization/show";
	}
}
