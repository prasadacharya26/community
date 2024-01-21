package com.community.auth.user.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.auth.user.VO.UserVo;
import com.community.auth.user.entity.UserEntity;
import com.community.auth.user.execption.UserExecption;
import com.community.auth.user.repository.UserRepository;
import com.community.auth.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserVo getUserDetails(Integer userId, String userEmail) throws UserExecption{
		UserVo userVo=null;
		try {
			UserEntity userEntity=null;
			if(userId!=null) {
				userEntity=userRepository.findByUserId(userId);
			}else if(userEmail!=null) {
				userEntity=userRepository.findByUserEmail(userEmail);
			}
			if(userEntity!=null) {
				userVo=userEntity.toUserVo();
			}else {
				throw new UserExecption("No Data Found");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userVo;
	}

	@Override
	public void addUserDetails(UserVo userVo) {
		try {
			if(userVo!=null && userVo.getUserEmail()!=null) {
				UserEntity userMaster=userRepository.findByUserEmail(userVo.getUserEmail());
				if(userMaster!=null) {
					throw new UserExecption("Email Already exists");
				}
			}
			UserEntity userEntity=userVo.toUserEntity();
			userRepository.save(userEntity);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void updateUserDetails(UserVo userVo) {
		try {
			if(userVo!=null && userVo.getUserEmail()!=null) {
				UserEntity userMaster=userRepository.findByUserEmail(userVo.getUserEmail());
				if(userMaster!=null) {
					userMaster=userVo.toUserEntity();
					userRepository.save(userMaster);
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public List<UserVo> getAllUserDetails(Boolean active) {
		List<UserVo> userVo=null;
		try {
			List<UserEntity> userEntity=null;
			if(active!=null) {
				userEntity=userRepository.findByUserDetails(active);
			}else {
				userEntity=userRepository.findByAllUser();
			}
			if(userEntity!=null) {
				userVo=new ArrayList<UserVo>();
				for(UserEntity userEntity2:userEntity) {
					userVo.add(userEntity2.toUserVo());
				}
				
			}else {
				throw new UserExecption("No Data Found");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userVo;
	}

	@Override
	public String getUserEmailDetails(String userEmail) {
		String userVo=null;
		try {
			UserEntity userEntity=null;
			if(userEmail!=null) {
				userEntity=userRepository.findByUserEmail(userEmail);
			}
			if(userEntity!=null) {
				userVo="Email ID is already registered";
			}else {
				userVo="Failure";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userVo;
	}

}
