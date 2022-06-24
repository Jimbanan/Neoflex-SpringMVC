package com.neoflex.spring.mvc.service;

import com.neoflex.spring.mvc.dao.UsersDAO;
import com.neoflex.spring.mvc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    @Override
    @Transactional
    public List<Users> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Override
    @Transactional
    public Users getUser(Long id) {
        return usersDAO.getUser(id);
    }

    @Override
    @Transactional
    public void saveUser(Users user) {
        usersDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void update(Long id, Users user) {
        usersDAO.update(id, user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        usersDAO.deleteUser(id);
    }
}
