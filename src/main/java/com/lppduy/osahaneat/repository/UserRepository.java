package com.lppduy.osahaneat.repository;

import com.lppduy.osahaneat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Integer> {
    List<Users> findByUsernameAndPassword(String username, String password);
    Users findByUsername(String userName);
}
