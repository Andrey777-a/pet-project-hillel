package com.example.springhillel.repository.jpaRepository;

import com.example.springhillel.model.entity.TaskAttribute;
import com.example.springhillel.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaTaskRepositoryImpl implements TaskRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void createTask(TaskAttribute taskAttribute) {

        entityManager.persist(taskAttribute);

    }

    @Override
    public void updateTask(TaskAttribute taskAttribute) {

        entityManager.persist(taskAttribute);

            }

    @Override
    public List<TaskAttribute> getTaskUser(int user) {
        TypedQuery<TaskAttribute> taskAttributeTypedQuery = entityManager.createQuery("from TaskAttribute", TaskAttribute.class);
        for (TaskAttribute taskAttribute: taskAttributeTypedQuery.getResultList()){
            System.out.println(taskAttribute.toString());
        }
        return taskAttributeTypedQuery.getResultList();
    }
}
