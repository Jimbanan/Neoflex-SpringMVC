package com.neoflex.spring.mvc.dao;

import com.neoflex.spring.mvc.config.Hibernate;
import com.neoflex.spring.mvc.entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsersDAOImpl implements UsersDAO {

    private Session session = Hibernate.getSessionFactory().openSession();
    private Transaction tr = session.beginTransaction();

    @Override
    public List<Users> getAllUsers() {
        List<Users> allUsers = session.createNamedQuery("getAllUsers", Users.class).getResultList();
        return allUsers;
    }

    @Override
    public Users getUser(Long id) {
        Optional<Users> user = session.createNamedQuery("getUser", Users.class)
                .setParameter("id", id)
                .getResultList()
                .stream()
                .findFirst();
        return user.get();
    }

    @Override
    public void saveUser(Users user) {
        session.saveOrUpdate(user);
    }

    public void update(Long id, Users user) {
        session.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        session.delete(getUser(id));
        tr.commit();
    }

}
