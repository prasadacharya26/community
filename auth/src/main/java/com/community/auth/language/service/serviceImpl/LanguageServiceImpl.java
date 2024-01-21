package com.community.auth.language.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.auth.language.entity.LanguageEntity;
import com.community.auth.language.repository.LanguageRepository;
import com.community.auth.language.service.LanguageService;
import com.community.auth.language.vo.LanguageVo;

import com.community.auth.user.execption.UserExecption;

@Service
public class LanguageServiceImpl implements LanguageService{
	
	@Autowired
	LanguageRepository languageRepository;

	@Override
	public LanguageVo getLanguageDetails(Integer languageId, String name) {

		LanguageVo languageVo=null;
		try {
			LanguageEntity languageEntity=null;
			if(languageId!=null) {
				languageEntity=languageRepository.findByLanguageId(languageId);
			}else if(name!=null) {
				languageEntity=languageRepository.findByLanguageName(name);
			}
			if(languageEntity!=null) {
				languageVo=languageEntity.toLanguageVo();
			}else {
				throw new UserExecption("No Data Found");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return languageVo;
	
	}

	@Override
	public List<LanguageVo> getAllLanguageDetails(Boolean active) {
		List<LanguageVo> languageVo=null;
		try {
			List<LanguageEntity> languageEntity=null;
			languageEntity=languageRepository.findByAllLanguage();
			if(languageEntity!=null) {
				languageVo=new ArrayList<LanguageVo>();
				for(LanguageEntity lanEntity:languageEntity) {
					languageVo.add(lanEntity.toLanguageVo());
				}
			}else {
				throw new UserExecption("No Data Found");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return languageVo;
	}
	

	@Override
	public void addLanguageDetails(LanguageVo languageVo) {
		try {
			LanguageEntity languageEntity=languageVo.toLanguageEntity();
			languageRepository.save(languageEntity);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void updateLanguageDetails(LanguageVo languageVo) {
		try {
			LanguageEntity languageEntity=languageVo.toLanguageEntity();
			languageRepository.save(languageEntity);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
