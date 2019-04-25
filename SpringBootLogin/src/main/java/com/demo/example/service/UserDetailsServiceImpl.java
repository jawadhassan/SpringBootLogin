package com.demo.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.AppRole;
import com.example.demo.model.AppUser;
import com.example.demo.repostories.AppRoleRepository;
import com.example.demo.repostories.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private AppRoleRepository appRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		AppUser appUser = this.appUserRepository.findAppUserWithRoles(userName);

		if (appUser == null) {
			System.out.println("User not found" + userName);
			throw new UsernameNotFoundException("User" + userName + "not found in database");

		}

		System.out.println("User Found:" + userName);

		List<AppRole> appRoles = new ArrayList<>();

		// this.appUserRepository.findByUserId(appUser.getUserId()).forEach(appRoles::add);
		// appRoles = appUser.getRolesList();
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

//		List<Long> appRoleIds = new ArrayList<>();

		for (int i = 0; i < appUser.getRolesList().size(); i++) {
//			Long appUserId = appUser.getRolesList().get(i).getRoleId();

//			AppRole role = appRoleRepository.findByRoleId(appUserId);

			if (appUser.getRolesList().get(i).getRoleName() != null) {
				GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getRolesList().get(i).getRoleName());
				grantList.add(authority);
			}

		}

//		if(!appRoles.isEmpty()) {
//			for(AppRole appRole : appRoles) {
//			GrantedAuthority authority = new SimpleGrantedAuthority(appRole.getRoleName());
//			grantList.add(authority);
//			
//			}
//		}

		UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), appUser.getEncrytedPassword(),
				grantList);

		return userDetails;
	}

}
