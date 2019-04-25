package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@NotNull
	private String userName;

	@NotNull
	private String encrytedPassword;

	@Column(nullable = false)
	@Type(type = "numeric_boolean")
	private boolean type;  

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<AppRole> rolesList = new ArrayList<AppRole>();

	public AppUser() {

	}



	public AppUser(Long userId,  String userName, String encrytedPassword, boolean type,
			List<AppRole> rolesList) {
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.type = type;
		this.rolesList = rolesList;
	}



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", userName=" + userName + ", encrytedPassword=" + encrytedPassword + "]";
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public List<AppRole> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<AppRole> rolesList) {
		this.rolesList = rolesList;
	}



}
