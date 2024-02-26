package com.lppduy.osahaneat.controller;

import com.lppduy.osahaneat.payload.ResponseData;
import com.lppduy.osahaneat.payload.request.SignUpRequest;
import com.lppduy.osahaneat.service.LoginService;
import com.lppduy.osahaneat.utils.JwtUtilsHelper;
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

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password) {

        ResponseData responseData = new ResponseData();

//        SecretKey key = Jwts.SIG.HS256.key().build();
//        String encrypted = Encoders.BASE64.encode(key.getEncoded());
//        System.out.println(">>>>>>>>> encrypted: " + encrypted);

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
