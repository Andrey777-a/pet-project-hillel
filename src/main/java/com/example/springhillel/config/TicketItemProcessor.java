package com.example.springhillel.config;

import com.example.springhillel.model.entity.StatusTicket;
import com.example.springhillel.model.entity.Ticket;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;

public class TicketItemProcessor implements ItemProcessor<Ticket, Ticket> {

    @Override
    public Ticket process(Ticket ticket) throws Exception {

        LocalDateTime localDateTime = ticket
                .getTimeEstimated();
//        StatusTicket statusTicket = new StatusTicket(5);
//

            if (LocalDateTime.now().isAfter(localDateTime)) {
//                ticket.setStatus(statusTicket);
                return ticket;
            }


        return null;
    }
}
