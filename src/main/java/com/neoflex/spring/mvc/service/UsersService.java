package com.neoflex.spring.mvc.service;

import com.neoflex.spring.mvc.entity.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAllUsers();

    Users getUser(Long id);

    void saveUser(Users user);

    void update(Long id, Users user);

    void deleteUser(Long id);

}
