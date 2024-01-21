package com.community.auth.role.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.community.auth.utils.JSONUtil;
import com.community.auth.utils.ResponseUtil;
import com.community.auth.role.constant.RoleConstant;
import com.community.auth.role.service.RoleService;
import com.community.auth.role.vo.RoleVO;

import net.sf.json.JSONObject;

@RestController
@RequestMapping(value=RoleConstant.ROLE)
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@GetMapping(value=RoleConstant.GET_ROLE_DETAILS)
	public ResponseEntity<JSONObject>getRoleDetails(@RequestParam(value="roleId",required = false) Integer roleId,@RequestParam(value="roleName",required=false) String roleName){
		JSONObject roleDetails=null;
		try {
			RoleVO roleVO=roleService.getRoleDetails(roleId,roleName);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("roleDetails", roleVO);
			roleDetails=ResponseUtil.getSuccessResponse("sucess", "sucess", jsonObject);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(roleDetails,HttpStatus.OK);
		
	}
	
	@GetMapping(value=RoleConstant.GET_ROLE_ALL_DETAILS)
	public ResponseEntity<JSONObject>getUserDetails(@RequestParam(value="active",required = false) Boolean active){
		JSONObject roleDetails=null;
		try {
			List<RoleVO> roleVO=roleService.getAllRoleDetails(active);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("allRoleDetails", roleVO);
			roleDetails=ResponseUtil.getSuccessResponse("sucess", "sucess", jsonObject);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(roleDetails,HttpStatus.OK);
		
	}
	
	@PostMapping(value=RoleConstant.ADD_ROLE_DETAILS)
	public ResponseEntity<JSONObject>addRoleDetails(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse ){
		JSONObject roleDetails=null;
		try {
			String role=httpServletRequest.getParameter("data");
			if(StringUtils.isNotEmpty(role)) {
				JSONObject jsonObject=new JSONObject();
				RoleVO roleVO=(RoleVO) JSONUtil.fromJson(role, RoleVO.class);
				if(roleVO.getRoleName()!=null) {
					roleService.addRoleDetails(roleVO);
					jsonObject.put("addRole", roleVO);
					roleDetails=ResponseUtil.getSuccessResponse("sucess", "Role Sucessfully Added", null);
				}
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(roleDetails,HttpStatus.OK);
		
	}
	
	@PutMapping(value=RoleConstant.UPDATE_ROLE_DETAILS)
	public ResponseEntity<JSONObject>updateRoleDetails(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse ){
		JSONObject roleDetails=null;
		try {
			String role=httpServletRequest.getParameter("data");
			if(StringUtils.isNotEmpty(role)) {
				JSONObject jsonObject=new JSONObject();
				RoleVO roleVO=(RoleVO) JSONUtil.fromJson(role, RoleVO.class);
				if(roleVO.getRoleName()!=null) {
					roleService.updateRoleDetails(roleVO);
					jsonObject.put("addRole", roleVO);
					roleDetails=ResponseUtil.getSuccessResponse("sucess", "Role Sucessfully Updated", null);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(roleDetails,HttpStatus.OK);
		
	}



}
