package com.community.auth.service;

import com.community.auth.user.VO.UserVo;

public interface LoginService {
    boolean validateUser(UserVo userVO);
}
