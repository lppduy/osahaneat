package com.lppduy.osahaneat.controller;

import com.lppduy.osahaneat.payload.ResponseData;
import com.lppduy.osahaneat.payload.request.SignUpRequest;
import com.lppduy.osahaneat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password) {

        ResponseData responseData = new ResponseData();

        if (loginService.checkLogin(username, password)) {
            responseData.setData(true);
        } else {
            responseData.setData(false);
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
