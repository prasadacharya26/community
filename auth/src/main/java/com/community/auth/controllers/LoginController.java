package com.community.auth.controllers;

import com.community.auth.service.LoginService;
import com.community.auth.user.VO.UserVo;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class LoginController {

    Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<JSONObject> authenticate (HttpServletRequest request, HttpServletResponse response){
        logger.info("Entered Authenticate Controller");
        boolean loginSuccess;
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
                logger.info("User-Authentication: "+username);
                UserVo userVO = new UserVo();
                userVO.setUserEmail(username);
                userVO.setPassword(password);
                loginSuccess = loginService.validateUser(userVO);
            }else{
                JSONObject errorResp = new JSONObject();
                errorResp.put("status","Failed");
                errorResp.put("message","Invalid Credentials");
                return new ResponseEntity<>(errorResp,HttpStatus.UNAUTHORIZED);
            }

            if(loginSuccess) {
                JSONObject successResp = new JSONObject();
                successResp.put("status","Success");
                successResp.put("message","Successfully Logged In");
                return new ResponseEntity<>(successResp,HttpStatus.OK);
            }
        }catch(Exception e){
            logger.info("Exception in Authenticate Controller");
        }
        JSONObject resp = new JSONObject();
        resp.put("status","Failed");
        resp.put("message","Login Failed, please check credentials");
        logger.info("Exiting Authenticate Controller");
        return new ResponseEntity<>(resp,HttpStatus.BAD_GATEWAY);
    }

    @PostMapping("/add-user")
    public ResponseEntity<JSONObject> addUser (HttpServletRequest request, HttpServletResponse response){
        logger.info("Entered addUser Controller");
        boolean loginSuccess;
        try{

        }catch(Exception e){
            logger.info("Exception in addUser Controller");
        }
        JSONObject resp = new JSONObject();
        resp.put("status","Failed");
        resp.put("message","Login Failed, please check credentials");
        logger.info("Exiting Authenticate Controller");
        return new ResponseEntity<>(resp,HttpStatus.BAD_GATEWAY);
    }

    
}
