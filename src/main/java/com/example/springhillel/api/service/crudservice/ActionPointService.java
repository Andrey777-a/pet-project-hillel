package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.api.service.AbstractServiceImpl;
import com.example.springhillel.model.dto.ActionPointDTO;
import com.example.springhillel.model.entity.ActionPoint;
import com.example.springhillel.repository.jpacrudrepozitory.ActionPointRepository;
import org.springframework.stereotype.Service;

@Service
public class ActionPointService extends AbstractServiceImpl<ActionPoint, ActionPointDTO, ActionPointRepository> {
}
