package com.lppduy.osahaneat.service.impl;

import com.lppduy.osahaneat.dto.UserDTO;
import com.lppduy.osahaneat.entity.Users;
import com.lppduy.osahaneat.repository.UserRepository;
import com.lppduy.osahaneat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
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

}
