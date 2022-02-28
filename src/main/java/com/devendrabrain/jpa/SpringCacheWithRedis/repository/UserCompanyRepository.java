package com.devendrabrain.jpa.SpringCacheWithRedis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devendrabrain.jpa.SpringCacheWithRedis.entity.UserCompany;

public interface UserCompanyRepository extends JpaRepository<UserCompany, Long>{

}
