package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.AbstractIntegrationTest;
import com.example.springhillel.model.entity.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TicketServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private TicketService ticketService;

    @Test
    public void testIntegrationFindByIdTicket(){
        Optional<Ticket> ticketOptional = ticketService.findById(1);

        Assertions.assertEquals("name task", ticketOptional.get().getName());
    }
    @Test
    public void testIntegrationGetAllTicket(){
        List<Ticket> roleList = ticketService.getAll();

        Assertions.assertFalse(roleList.isEmpty());
        Assertions.assertEquals(78, ticketService.getAll().size());
    }

}
