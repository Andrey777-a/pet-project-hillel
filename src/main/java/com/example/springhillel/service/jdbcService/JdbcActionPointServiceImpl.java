package com.example.springhillel.service.jdbcService;

import com.example.springhillel.model.entity.ActionPoint;
import com.example.springhillel.repository.ActionPointRepository;
import com.example.springhillel.service.ActionPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdbcActionPointServiceImpl implements ActionPointService {

    @Qualifier("jdbcActionPointRepositoryImpl")
    @Autowired
    private ActionPointRepository jpaRepository;

    @Override
    @Transactional
    public void createActionPoint(ActionPoint actionPoint) {
        jpaRepository.createActionPoint(actionPoint);
    }

    @Override
    @Transactional
    public void deleteActionPoint(long id) {
        jpaRepository.deleteActionPoint(id);
    }
}
