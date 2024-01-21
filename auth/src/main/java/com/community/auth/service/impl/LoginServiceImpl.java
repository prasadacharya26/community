package com.community.auth.service.impl;

import com.community.auth.service.LoginService;
import com.community.auth.utils.EncryptDecryptPassword;
import com.community.auth.user.VO.UserVo;
import com.community.auth.user.entity.UserEntity;
import com.community.auth.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userMasterRepo;

    @Override
    public boolean validateUser(UserVo userVO) {
        boolean login = false;
        UserEntity userMaster = userMasterRepo.findByUserEmail(userVO.getUserEmail());
        if(!ObjectUtils.isEmpty(userMaster) && Optional.of(userMaster.getPassword()).isPresent()){
            login = EncryptDecryptPassword.checkPassword(userVO.getPassword(),userMaster.getPassword());
        }
        return login;
    }
}
