package com.community.auth.role.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.auth.role.entity.RoleEntity;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{

	@Query(value="select * from role_master where role_id=:roleId",nativeQuery = true)
	RoleEntity findByRoleId(@Param("roleId")Integer roleId);

	@Query(value="select * from role_master where role_name=:roleName",nativeQuery = true)
	RoleEntity findByRoleName(@Param("roleName")String roleName);

	@Query(value="select * from role_master where active=:active",nativeQuery = true)
	List<RoleEntity> findByRoleListByActive(@Param("active")Boolean active);

	@Query(value="select * from role_master",nativeQuery = true)
	List<RoleEntity> findByAllRole();

}
