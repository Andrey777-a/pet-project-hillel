package com.example.springhillel.api.controller;

import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Qualifier("ticketServiceImpl")
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTask(){
        return ticketService.getAllTask();
    }

    @PostMapping
    public void createTask(@RequestBody TicketDTO taskAttribute) {

        ticketService.createTask(taskAttribute);

    }

    @PutMapping
    public void updateTask(@RequestBody Ticket ticket) {

        ticketService.updateTask(ticket);

    }

    @GetMapping("/get-ticket-user/{id}")
    public List<Ticket> getTaskUser(@PathVariable int id) {

        return ticketService.getTaskUser(id);

    }

    @GetMapping("/get-ticket/{id}")
    public Ticket getTask(@PathVariable long id) {

        return ticketService.getTask(id);

    }

    @PutMapping("/{idTicket}")
    public void deleteTask(@PathVariable long idTicket) {

        ticketService.deleteTask(idTicket);

    }

}
