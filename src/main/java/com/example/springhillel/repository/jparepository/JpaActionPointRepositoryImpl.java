package com.example.springhillel.repository.jparepository;

import com.example.springhillel.model.entity.ActionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class JpaActionPointRepositoryImpl implements ActionPointRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void createActionPoint(ActionPoint actionPoint) {
        entityManager.persist(actionPoint);
    }

    @Override
    public void deleteActionPoint(long id) {

        ActionPoint actionPoint = entityManager.find(ActionPoint.class, id);

        entityManager.remove(actionPoint);

    }
}
