package com.community.auth.user.VO;

import com.community.auth.language.entity.LanguageEntity;
import com.community.auth.role.entity.RoleEntity;
import com.community.auth.user.entity.UserEntity;

public class UserVo {
	private Integer userId;
	private String userFirstName;
	private String userLastName;
	private String password;
	private String userEmail;
	private String mobileNumber;
	private boolean active;
	private Integer roleId;
	private String roleName;
	private String profilePic;
	private Integer languageId;
	private String languageName;
	
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
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public Integer getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	public UserEntity toUserEntity() {
		UserEntity userEntity=new UserEntity();
		if(this.getUserId()!=null)
			userEntity.setUserId(this.getUserId());
		userEntity.setUserFirstName(this.getUserFirstName());
		userEntity.setUserLastName(this.getUserLastName());
		userEntity.setUserEmail(this.getUserEmail());
		userEntity.setActive(this.isActive());
		userEntity.setPassword(this.getPassword());
		if(this.getRoleId()!=null) {
			RoleEntity roleEntity=new RoleEntity();
			roleEntity.setRoleId(this.getRoleId());
			userEntity.setRoleEntity(roleEntity);
		}
		if(this.getLanguageId()!=null) {
			LanguageEntity languageEntity=new LanguageEntity();
			languageEntity.setLanguageId(this.getLanguageId());
			userEntity.setLanguageEntity(languageEntity);
		}
		userEntity.setMobileNumber(this.getMobileNumber());
		return userEntity;
		
	}
}
