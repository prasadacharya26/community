package com.community.auth.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.community.auth.language.entity.LanguageEntity;
import com.community.auth.role.entity.RoleEntity;
import com.community.auth.user.VO.UserVo;

@Entity
@Table(name="user_master")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(name="native",strategy = "native")
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_first_name")
	private String userFirstName;
	
	@Column(name="user_last_name")
	private String userLastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="mobile_no")
	private String mobileNumber;
	
	@Column(name="active_user")
	private boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role_id",referencedColumnName = "role_id")
	private RoleEntity roleEntity;
	
	@Column(name="user_profile_pic")
	private String profilePic;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="language_id",referencedColumnName = "language_id")
	private LanguageEntity languageEntity;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public LanguageEntity getLanguageEntity() {
		return languageEntity;
	}

	public void setLanguageEntity(LanguageEntity languageEntity) {
		this.languageEntity = languageEntity;
	}

	public UserVo toUserVo() {
		UserVo userVo=new UserVo();
		userVo.setUserId(this.getUserId());
		userVo.setUserFirstName(this.getUserFirstName());
		userVo.setUserLastName(this.getUserLastName());
		userVo.setUserEmail(this.getUserEmail());
		if(this.getRoleEntity()!=null) {
			userVo.setRoleId(this.getRoleEntity().getRoleId());
			userVo.setRoleName(this.getRoleEntity().getRoleAliasName());
		}
		userVo.setActive(this.isActive());
		if(this.getLanguageEntity()!=null) {
			userVo.setLanguageId(this.getLanguageEntity().getLanguageId());
			userVo.setLanguageName(this.getLanguageEntity().getLanguageName());
		}
		userVo.setMobileNumber(this.getMobileNumber());
		return userVo;
		
	}
}
