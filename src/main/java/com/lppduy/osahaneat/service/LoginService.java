package com.lppduy.osahaneat.service;

import com.lppduy.osahaneat.dto.UserDTO;
import com.lppduy.osahaneat.entity.Users;
import com.lppduy.osahaneat.payload.request.SignUpRequest;
import com.lppduy.osahaneat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface LoginService {

    public List<UserDTO> getAllUser();
    boolean checkLogin(String username, String password);
    boolean addUser(SignUpRequest signUpRequest);
}
