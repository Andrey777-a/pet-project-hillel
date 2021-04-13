package com.example.springhillel.springbatch.ticket;

import com.example.springhillel.model.entity.Ticket;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

public class TicketItemProcessor implements ItemProcessor<Ticket, Ticket> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Ticket process(Ticket ticket) {

        Ticket ticketEntity = entityManager.find(Ticket.class, ticket.getId());

//        Ticket ticket1 = ticket;
        LocalDateTime localDateTime = ticket
                .getTimeEstimated();

        if (LocalDateTime.now().isAfter(localDateTime) && ticketEntity.getStatus().getId() != 5) {

            return ticket;

        }

        return null;

    }
}
