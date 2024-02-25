package com.lppduy.osahaneat.service;

import com.lppduy.osahaneat.dto.UserDTO;
import com.lppduy.osahaneat.entity.Roles;
import com.lppduy.osahaneat.entity.Users;
import com.lppduy.osahaneat.payload.request.SignUpRequest;
import com.lppduy.osahaneat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUser() {
        List<Users> listUser = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (Users users : listUser) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(users.getUsername());
            userDTO.setPasswod(userDTO.getPasswod());
            userDTO.setFullname(users.getFullname());
            userDTO.setCreateDate(users.getCreateDate());
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    @Override
    public boolean checkLogin(String username, String password) {

        List<Users> usersList = userRepository.findByUsernameAndPassword(username,password);

        return !usersList.isEmpty();
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {

        Roles roles = new Roles();
        roles.setId(signUpRequest.getRoleId());


        Users users = new Users();
        users.setFullname(signUpRequest.getFullname());
        users.setPassword(signUpRequest.getPassword());
        users.setUsername(signUpRequest.getEmail());
        users.setRoles(roles);

        try {
            userRepository.save(users);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
