package com.community.auth.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.community.auth.utils.JSONUtil;
import com.community.auth.utils.ResponseUtil;
import com.community.auth.user.VO.UserVo;
import com.community.auth.user.constant.UserConstant;
import com.community.auth.user.service.UserService;
import net.sf.json.JSONObject;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value=UserConstant.GET_USER_DETAILS)
	public ResponseEntity<JSONObject>getUsersDetails(@RequestParam(value="userId",required = false) Integer userId,@RequestParam(value="userEmail",required=false) String userEmail){
		JSONObject userDetails=null;
		try {
			UserVo userVo=userService.getUserDetails(userId,userEmail);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("UserDetails", userVo);
			userDetails=ResponseUtil.getSuccessResponse("sucess", "sucess", jsonObject);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(userDetails,HttpStatus.OK);
		
	}
	
	@GetMapping(value=UserConstant.GET_ALL_USER_DETAILS)
	public ResponseEntity<JSONObject>getAllUsersDetails(@RequestParam(value="active",required = false) Boolean active){
		JSONObject userDetails=null;
		try {
			List<UserVo> userVo=userService.getAllUserDetails(active);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("UserDetails", userVo);
			userDetails=ResponseUtil.getSuccessResponse("sucess", "sucess", jsonObject);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(userDetails,HttpStatus.OK);
		
	}
	
	@PostMapping(value=UserConstant.ADD_USER_DETAILS)
	public ResponseEntity<JSONObject>addUsersDetails(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse ){
		JSONObject userDetails=null;
		try {
			String user=httpServletRequest.getParameter("user");
			if(StringUtils.isNotEmpty(user)) {
				UserVo userVo=(UserVo) JSONUtil.fromJson(user, UserVo.class);
				if(userVo.getUserEmail()!=null) {
					userService.addUserDetails(userVo);
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("user", userVo);
					userDetails=ResponseUtil.getSuccessResponse("sucess", "User Added Sucessfully", null);
				}
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(userDetails,HttpStatus.OK);
		
	}
	
	@PutMapping(value=UserConstant.UPDATE_USER_DETAILS)
	public ResponseEntity<JSONObject>updateUsersDetails(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse ){
		JSONObject userDetails=null;
		try {
			String user=httpServletRequest.getParameter("user");
			if(StringUtils.isNotEmpty(user)) {
				UserVo userVo=(UserVo) JSONUtil.fromJson(user, UserVo.class);
				if(userVo.getUserEmail()!=null) {
					userService.updateUserDetails(userVo);
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("user", userVo);
					userDetails=ResponseUtil.getSuccessResponse("sucess", "User Updated Sucessfully", null);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(userDetails,HttpStatus.OK);
		
	}
	
	@GetMapping(value=UserConstant.CHECK_USER_EMAIL)
	public ResponseEntity<JSONObject>getUsersEmailDetails(@RequestParam String userEmail){
		JSONObject userDetails=null;
		try {
			String userVo=userService.getUserEmailDetails(userEmail);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("checkEMail", userVo);
			userDetails=ResponseUtil.getSuccessResponse("sucess", userVo+ "Email Already exists", null);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(userDetails,HttpStatus.OK);
		
	}

}
