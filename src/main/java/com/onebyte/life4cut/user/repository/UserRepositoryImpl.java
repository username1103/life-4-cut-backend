package com.onebyte.life4cut.user.repository;

import com.onebyte.life4cut.user.domain.User;
import com.onebyte.life4cut.user.domain.UserRepository;
import com.onebyte.life4cut.user.repository.dto.SearchUserDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.onebyte.life4cut.user.domain.QUser.user;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager em;

    private final JPAQueryFactory query;

    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public User save(User user) {
        em.persist(user);

        return user;
    }

    public List<SearchUserDto> search(String nickname) {
        return query.select(Projections
                .constructor(
                        SearchUserDto.class,
                        user.id,
                        user.nickname,
                        user.email))
                .from(user)
                .where(user.nickname.like("%" + nickname))
                .fetch();
    }

}
