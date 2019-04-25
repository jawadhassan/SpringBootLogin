package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AppRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;
	
	@NotNull
    private String roleName;

	public AppRole() {
	}

	public AppRole(Long roleId, @NotNull String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "AppRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	
	
	
	
	
	
}
