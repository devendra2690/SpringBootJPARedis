package com.devendrabrain.jpa.SpringCacheWithRedis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devendrabrain.jpa.SpringCacheWithRedis.dao.UserCompanyDAO;
import com.devendrabrain.jpa.SpringCacheWithRedis.entity.UserCompany;

@Service
public class UserCompanyService {

	@Autowired
	UserCompanyDAO companyDAO;

	public List<UserCompany> create(List<UserCompany> userCompany) {
		
		List<UserCompany> companies = new ArrayList<UserCompany>();		
		for (UserCompany userCompanyobj : userCompany) {
			companies.add(companyDAO.create(userCompanyobj));
		}
		return companies;
	}

	public List<UserCompany> findAll() {
		List<UserCompany> usercompany = companyDAO.findAll();
	
		return usercompany;
	}

	public UserCompany get(Long id) {
		return companyDAO.fetchById(id);
	}

	public UserCompany update(UserCompany company) {
		return companyDAO.update(company);
	}

	public void delete(Long id) {
		companyDAO.delete(id);		
	}
	
	
	
}
