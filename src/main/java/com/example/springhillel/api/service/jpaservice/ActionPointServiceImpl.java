package com.example.springhillel.api.service.jpaservice;

import com.example.springhillel.exception.NotFoundException;
import com.example.springhillel.model.entity.ActionPoint;
import com.example.springhillel.repository.jparepository.ActionPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class ActionPointServiceImpl implements ActionPointService {

    @Qualifier("jpaActionPointRepositoryImpl")
    @Autowired
    private ActionPointRepository jpaRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createActionPoint(ActionPoint actionPoint) {
        jpaRepository.createActionPoint(actionPoint);
    }

    @Override
    @Transactional
    public void deleteActionPoint(long id) {
        validActionPoint(id);

        jpaRepository.deleteActionPoint(id);
    }

    private void validActionPoint(long id){

        ActionPoint actionPoint = entityManager.find(ActionPoint.class, id);

        if(actionPoint == null){
            throw new NotFoundException("Action Point not found");
        }

    }

}
