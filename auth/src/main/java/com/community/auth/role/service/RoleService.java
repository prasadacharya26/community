package com.community.auth.role.service;

import java.util.List;

import com.community.auth.role.vo.RoleVO;

public interface RoleService {

	RoleVO getRoleDetails(Integer roleId, String roleName);

	void addRoleDetails(RoleVO roleVO);

	void updateRoleDetails(RoleVO roleVO);

	List<RoleVO> getAllRoleDetails(Boolean active);

}
