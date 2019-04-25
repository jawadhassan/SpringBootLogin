package com.example.demo.repostories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AppRole;

@Repository
public interface AppRoleRepository extends CrudRepository<AppRole, Long> {
	
	AppRole findByRoleId(Long appRoleId);
}
