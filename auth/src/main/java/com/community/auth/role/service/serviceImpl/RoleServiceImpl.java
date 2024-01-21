package com.community.auth.role.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.auth.role.entity.RoleEntity;
import com.community.auth.role.repository.RoleRepository;
import com.community.auth.role.service.RoleService;
import com.community.auth.role.vo.RoleVO;
import com.community.auth.user.execption.UserExecption;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public RoleVO getRoleDetails(Integer roleId, String roleName) {
		RoleVO roleVO=null;
		try {
			RoleEntity roleEntity=null;
			if(roleId!=null) {
				roleEntity=roleRepository.findByRoleId(roleId);
			}else if(roleName!=null) {
				roleEntity=roleRepository.findByRoleName(roleName);
			}
			if(roleEntity!=null) {
				roleVO=roleEntity.toRoleVO();
			}else {
				throw new UserExecption("No Data Found");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return roleVO;
	}

	@Override
	public void addRoleDetails(RoleVO roleVO) {
		try {
			RoleEntity roleEntity=roleVO.toRoleEntity();
			roleRepository.save(roleEntity);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void updateRoleDetails(RoleVO roleVO) {
		try {
			RoleEntity roleEntity=roleVO.toRoleEntity();
			roleRepository.save(roleEntity);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public List<RoleVO> getAllRoleDetails(Boolean active) {
		List<RoleVO> roleVO=null;
		try {
			List<RoleEntity> roleEntities=null;
			if(active!=null) {
				roleEntities=roleRepository.findByRoleListByActive(active);
			}else{
				roleEntities=roleRepository.findByAllRole();
			}
			if(roleEntities!=null) {
				roleVO = new ArrayList<RoleVO>();
				for(RoleEntity roleEntity:roleEntities) {
					roleVO.add(roleEntity.toRoleVO());
				}
					
			}else {
				throw new UserExecption("No Data Found");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return roleVO;
	}

}
