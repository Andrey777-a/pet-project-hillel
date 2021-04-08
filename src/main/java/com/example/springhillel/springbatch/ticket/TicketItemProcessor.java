package com.example.springhillel.springbatch.ticket;

import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.Ticket;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

public class TicketItemProcessor implements ItemProcessor<TicketDTO, TicketDTO> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public TicketDTO process(TicketDTO ticketDTO) {

        Ticket ticket = entityManager.find(Ticket.class, ticketDTO.getId());

        LocalDateTime localDateTime = ticketDTO
                .getTimeEstimated();

        if (LocalDateTime.now().isAfter(localDateTime) && ticket.getStatus().getId() != 5) {

            return ticketDTO;

        }

        return null;

    }
}
