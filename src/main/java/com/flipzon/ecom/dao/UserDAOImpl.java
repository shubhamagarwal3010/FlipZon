package com.flipzon.ecom.dao;

import com.flipzon.ecom.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean addUser(User user) {
        entityManager.persist(user);
        return entityManager.contains(user);
    }

}