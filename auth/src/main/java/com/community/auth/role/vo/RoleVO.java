package com.community.auth.role.vo;

import com.community.auth.role.entity.RoleEntity;

public class RoleVO {
	private Integer roleId;
	
	private String roleName;
	
	private String roleAliasName;
	
	private Boolean active;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleAliasName() {
		return roleAliasName;
	}

	public void setRoleAliasName(String roleAliasName) {
		this.roleAliasName = roleAliasName;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public RoleEntity toRoleEntity() {
		RoleEntity roleEntity=new RoleEntity();
		if(this.getRoleId()!=null) {
			roleEntity.setRoleId(this.getRoleId());	
		}
		roleEntity.setRoleName(this.getRoleName());
		roleEntity.setRoleAliasName(this.getRoleAliasName());
		roleEntity.setActive(this.getActive());
		return roleEntity;
	}
}
