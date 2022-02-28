package com.devendrabrain.jpa.SpringCacheWithRedis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devendrabrain.jpa.SpringCacheWithRedis.entity.UserCompany;
import com.devendrabrain.jpa.SpringCacheWithRedis.service.UserCompanyService;

@RestController
public class UserCompanyController {

	@Autowired
	private UserCompanyService companyService;
	
	@PostMapping("/create")
	public List<UserCompany> create(@RequestBody List<UserCompany> userCompany) {		
		return companyService.create(userCompany);
	}
	
	@GetMapping("/findAll")
	public List<UserCompany> findAll() {		
		return companyService.findAll();
	}
	
	@GetMapping("/user/{id}")
	public UserCompany userCompany(@PathVariable("id") Long id) {
		return companyService.get(id);
	}
	
	@PostMapping("/user/update")
	public UserCompany update(@RequestBody UserCompany company) {
		return companyService.update(company);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		companyService.delete(id);
		return "deleted User : "+id;
	}
}
