package com.onebyte.life4cut.user.repository;

import com.onebyte.life4cut.user.domain.User;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public User save(User user) {
        em.persist(user);

        return user;
    }
}
