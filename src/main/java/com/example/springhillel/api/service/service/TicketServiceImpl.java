package com.example.springhillel.api.service.service;

import com.example.springhillel.exception.NotFoundException;
import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.repository.TicketRepository;
import com.example.springhillel.api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Qualifier("jpaTicketRepositoryImpl")
    @Autowired
    private TicketRepository jpaRepository;

    @Override
    public List<Ticket> getAllTask() {
        return jpaRepository.getAllTask();
    }

    @Override
    @Transactional
    public void createTask(TicketDTO taskAttribute) {
        jpaRepository.createTask(taskAttribute);
    }

    @Override
    @Transactional
    public void updateTask(Ticket ticket) {

        jpaRepository.updateTask(ticket);
    }

    @Override
    @Transactional
    public List<Ticket> getTaskUser(int user) {
        return jpaRepository.getTaskUser(user);
    }

    @Override
    @Transactional
    public Ticket getTask(long id) {

        validTask(id);

        return jpaRepository.getTask(id);

    }

    @Override
    @Transactional
    public void deleteTask(long idTask) {

        validTask(idTask);

        jpaRepository.deleteTask(idTask);
    }

    private void validTask(long idTask){
        Ticket ticket = jpaRepository.getTask(idTask);

        if(ticket == null){
            throw new NotFoundException("Task not found");
        }
    }

}
