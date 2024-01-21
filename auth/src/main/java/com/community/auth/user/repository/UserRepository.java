package com.community.auth.user.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.auth.user.entity.UserEntity;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	@Query(value="select * from user_master where user_id=:userId",nativeQuery = true)
	UserEntity findByUserId(@Param("userId")Integer userId);

	@Query(value="select * from user_master where user_email=:userEmail",nativeQuery = true)
	UserEntity findByUserEmail(@Param("userEmail")String userEmail);

	@Query(value="select * from user_master where active=:active",nativeQuery = true)
	List<UserEntity> findByUserDetails(@Param("active")Boolean active);

	@Query(value="select * from user_master",nativeQuery = true)
	List<UserEntity> findByAllUser();

}
