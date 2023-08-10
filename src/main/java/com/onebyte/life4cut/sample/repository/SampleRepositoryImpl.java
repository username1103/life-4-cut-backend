package com.onebyte.life4cut.sample.repository;

import com.onebyte.life4cut.sample.domain.Sample;
import com.onebyte.life4cut.sample.domain.SampleRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class SampleRepositoryImpl implements SampleRepository {
    
    private final EntityManager em;

    private final JPAQueryFactory query;

    public SampleRepositoryImpl(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Sample save(Sample sample) {
        em.persist(sample);

        return sample;
    }
}
