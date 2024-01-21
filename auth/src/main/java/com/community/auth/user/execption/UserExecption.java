package com.community.auth.user.execption;

import org.hibernate.service.internal.ServiceDependencyException;

public class UserExecption extends ServiceDependencyException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserExecption(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

}
