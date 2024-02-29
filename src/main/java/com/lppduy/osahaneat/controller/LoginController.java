package com.lppduy.osahaneat.controller;

import com.lppduy.osahaneat.payload.ResponseData;
import com.lppduy.osahaneat.payload.request.SignUpRequest;
import com.lppduy.osahaneat.service.LoginService;
import com.lppduy.osahaneat.utils.JwtUtilsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password) {

        ResponseData responseData = new ResponseData();

        logger.trace("KIEM TRA TRACE LOG");
        logger.debug("KIEM TRA DEBUG LOG");
        logger.info("KIEM TRA INFO LOG");
        logger.warn("KIEM TRA WARN LOG");
        logger.error("KIEM TRA ERROR LOG");

        if (loginService.checkLogin(username, password)) {
            String token = jwtUtilsHelper.generateToken(username);
            responseData.setData(token);
        } else {
            responseData.setData("");
            responseData.setSuccess(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {

        ResponseData responseData = new ResponseData();

        responseData.setData(loginService.addUser(signUpRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
