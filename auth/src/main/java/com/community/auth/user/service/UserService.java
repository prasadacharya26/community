package com.community.auth.user.service;

import java.util.List;

import com.community.auth.user.VO.UserVo;


public interface UserService {

	UserVo getUserDetails(Integer userId, String userEmail);

	void addUserDetails(UserVo userVo);

	void updateUserDetails(UserVo userVo);

	List<UserVo> getAllUserDetails(Boolean active);

	String getUserEmailDetails(String userEmail);

}
