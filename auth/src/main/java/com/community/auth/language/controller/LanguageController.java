package com.community.auth.language.controller;

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

import com.community.auth.language.constant.LanguageConstant;
import com.community.auth.language.service.LanguageService;
import com.community.auth.language.vo.LanguageVo;
import com.community.auth.utils.JSONUtil;
import com.community.auth.utils.ResponseUtil;

import net.sf.json.JSONObject;

@RestController
@RequestMapping(value=LanguageConstant.LANGUAGE)
public class LanguageController {


	@Autowired
	LanguageService languageService;
	
	@GetMapping(value=LanguageConstant.GET_LANGUAGE_DETAILS)
	public ResponseEntity<JSONObject>getLanguageDetails(@RequestParam(value="languageId",required = false) Integer languageId,@RequestParam(value="name",required=false) String name){
		JSONObject roleDetails=null;
		try {
			LanguageVo languageVo=languageService.getLanguageDetails(languageId,name);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("roleDetails", languageVo);
			roleDetails=ResponseUtil.getSuccessResponse("sucess", "sucess", jsonObject);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(roleDetails,HttpStatus.OK);
		
	}
	
	@GetMapping(value=LanguageConstant.GET_LANGUAGE_ALL_DETAILS)
	public ResponseEntity<JSONObject>getLanguagerDetails(@RequestParam(value="active",required = false) Boolean active){
		JSONObject roleDetails=null;
		try {
			List<LanguageVo> languageVos=languageService.getAllLanguageDetails(active);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("allRoleDetails", languageVos);
			roleDetails=ResponseUtil.getSuccessResponse("sucess", "sucess", jsonObject);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(roleDetails,HttpStatus.OK);
		
	}
	
	@PostMapping(value=LanguageConstant.ADD_LANGUAGAE_DETAILS)
	public ResponseEntity<JSONObject>addLanguageDetails(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse ){
		JSONObject roleDetails=null;
		try {
			String data=httpServletRequest.getParameter("data");
			if(StringUtils.isNotEmpty(data)) {
				JSONObject jsonObject=new JSONObject();
				LanguageVo languageVo=(LanguageVo) JSONUtil.fromJson(data, LanguageVo.class);
				if(languageVo.getLanguageName()!=null) {
					languageService.addLanguageDetails(languageVo);
					jsonObject.put("addLanguage", languageVo);
					roleDetails=ResponseUtil.getSuccessResponse("sucess", "Language Sucessfully Added", null);
				}
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(roleDetails,HttpStatus.OK);
		
	}
	
	@PutMapping(value=LanguageConstant.UPDATE_LANGUAGE_DETAILS)
	public ResponseEntity<JSONObject>updateLanguageDetails(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse ){
		JSONObject roleDetails=null;
		try {
			String data=httpServletRequest.getParameter("data");
			if(StringUtils.isNotEmpty(data)) {
				JSONObject jsonObject=new JSONObject();
				LanguageVo languageVo=(LanguageVo) JSONUtil.fromJson(data, LanguageVo.class);
				if(languageVo.getLanguageName()!=null) {
					languageService.updateLanguageDetails(languageVo);
					jsonObject.put("updateLanguage", languageVo);
					roleDetails=ResponseUtil.getSuccessResponse("sucess", "Language Sucessfully Updated", null);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(roleDetails,HttpStatus.OK);
		
	}




}
