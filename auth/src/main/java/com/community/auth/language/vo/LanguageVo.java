package com.community.auth.language.vo;

import com.community.auth.language.entity.LanguageEntity;

public class LanguageVo {
	private Integer languageId;

	private String languageName;

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	public LanguageEntity toLanguageEntity() {
		LanguageEntity languageEntity=new LanguageEntity();
		if(this.getLanguageId()!=null) {
			languageEntity.setLanguageId(this.getLanguageId());
		}
		languageEntity.setLanguageName(this.getLanguageName());
		return languageEntity;
		
	}
}
