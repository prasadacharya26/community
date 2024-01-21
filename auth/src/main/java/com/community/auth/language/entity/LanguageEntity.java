package com.community.auth.language.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.community.auth.language.vo.LanguageVo;

@Entity
@Table(name="language_master")
public class LanguageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(name="native",strategy = "native")
	@Column(name="language_id")
	private Integer languageId;
	
	@Column(name="language_name")
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

	public LanguageVo toLanguageVo() {
		LanguageVo languageVo=new LanguageVo();
		languageVo.setLanguageId(this.getLanguageId());
		languageVo.setLanguageName(this.getLanguageName());
		return languageVo;
		
	}
}
