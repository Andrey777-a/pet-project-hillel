package com.example.springhillel.api.controller.crudcontroller;

import com.example.springhillel.api.controller.AbstractControllerImpl;
import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.Ticket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ticketControllerCrud")
@RequestMapping("/ticket")
public class TicketController extends AbstractControllerImpl<Ticket, TicketDTO> {
}
