package com.community.auth.language.service;

import java.util.List;

import com.community.auth.language.vo.LanguageVo;

public interface LanguageService {

	LanguageVo getLanguageDetails(Integer languageId, String name);

	List<LanguageVo> getAllLanguageDetails(Boolean active);

	void addLanguageDetails(LanguageVo languageVo);

	void updateLanguageDetails(LanguageVo languageVo);

}
