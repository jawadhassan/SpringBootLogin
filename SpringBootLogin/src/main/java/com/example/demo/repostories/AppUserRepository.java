package com.example.demo.repostories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AppRole;
import com.example.demo.model.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {

	AppUser findByUserName(String userName);
	
	//public Iterable<AppRole> findByUserId(Long userId);
//	@Query("from  AppRole ar inner join user_role where au.user.id=:userId")
//	public Iterable<AppRole> findByUserId(Long userId);
	
	 @Query("from AppUser p JOIN FETCH p.rolesList roles WHERE p.userName=(:userName)")
	 public AppUser findAppUserWithRoles(@Param("userName") String userName);
	

}
