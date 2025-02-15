package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.api.service.AbstractServiceImpl;
import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.repository.jpacrudrepozitory.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends AbstractServiceImpl<Ticket, TicketDTO, TicketRepository> {
}
