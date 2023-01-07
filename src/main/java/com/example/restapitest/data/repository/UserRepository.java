package com.example.restapitest.data.repository;

import com.example.restapitest.data.entity.UserEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final EntityManager em;

    public void save(UserEntity user) {
        em.persist(user);
    }

    public UserEntity findOne(Long id) {
        return em.find(UserEntity.class, id);
    }

    public List<UserEntity> findAll() {
        return em.createQuery("select u from UserEntity u", UserEntity.class)
                .getResultList();
    }

    public List<UserEntity> findByName(String name) {
        return em.createQuery("select u from UserEntity u where u.name = :name", UserEntity.class)
                .setParameter("name", name)
                .getResultList();
    }



}
