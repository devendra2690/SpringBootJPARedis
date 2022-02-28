package com.devendrabrain.jpa.SpringCacheWithRedis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.devendrabrain.jpa.SpringCacheWithRedis.entity.UserCompany;
import com.devendrabrain.jpa.SpringCacheWithRedis.repository.UserCompanyRepository;

@Repository
public class UserCompanyDAO {

	@Autowired
	UserCompanyRepository companyRepository;
	
	public UserCompany create(UserCompany userCompany) {
		return companyRepository.save(userCompany);
	}
	
	@Cacheable(value = "userCompanies")
	public List<UserCompany> findAll() {
		return companyRepository.findAll();
	}
	
	@CachePut(value = "userCompanies", key = "#userCompany.id")
	public UserCompany update(UserCompany userCompany) {
		return companyRepository.save(userCompany);

	}
	
	@Cacheable(value = "userCompanies", key = "#id")
	public UserCompany fetchById(Long id) {		
		return companyRepository.findById(id).orElse(null);
	}
	
	@CacheEvict(key = "#userCompanyId", value = "userCompanies")
	public void delete(Long userCompanyId) {
		companyRepository.deleteById(userCompanyId);
	}
}
