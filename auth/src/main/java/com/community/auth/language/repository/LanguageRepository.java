package com.community.auth.language.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.auth.language.entity.LanguageEntity;


@Repository
@Transactional
public interface LanguageRepository  extends JpaRepository<LanguageEntity, Integer>{

	@Query(value="select * from language_master where language_id=:languageId",nativeQuery = true)
	LanguageEntity findByLanguageId(@Param("languageId")Integer languageId);

	@Query(value="select * from language_master where language_name=:languageName",nativeQuery = true)
	LanguageEntity findByLanguageName(@Param("languageName")String languageName);

	@Query(value="select * from language_master",nativeQuery = true)
	List<LanguageEntity> findByAllLanguage();
}
