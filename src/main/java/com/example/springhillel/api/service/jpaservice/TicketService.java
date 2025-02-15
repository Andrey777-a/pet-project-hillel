package com.example.springhillel.api.service.jpaservice;

import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAllTask();
    void createTask(TicketDTO taskAttribute);
    void updateTask(Ticket ticket);
    List<Ticket> getTaskUser(int user);
    Ticket getTask(long id);
    void deleteTask(long idTask);

}
