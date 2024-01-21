package com.community.auth.role.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.community.auth.role.vo.RoleVO;

@Entity
@Table(name="role_master")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(name="native",strategy = "native")
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_alias_name")
	private String roleAliasName;
	
	@Column(name="active")
	private boolean active;

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
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public RoleVO toRoleVO() {
		RoleVO roleVO=new RoleVO();
		roleVO.setRoleId(this.getRoleId());
		roleVO.setRoleName(this.getRoleName());
		roleVO.setRoleAliasName(this.getRoleAliasName());
		roleVO.setActive(this.isActive());
		return roleVO;
		
	}

}
