package com.example.springhillel.api.service.crudservice.convert;

import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.StatusTicket;
import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.model.entity.TypeTicket;
import com.example.springhillel.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class TicketConvert implements AbstractConvert<Ticket, TicketDTO> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Ticket convertToEntity(TicketDTO ticketDTO) {

        StatusTicket statusTicket = entityManager.find(StatusTicket.class, ticketDTO.getStatus());
        User user = entityManager.find(User.class, ticketDTO.getAssignee());
        TypeTicket typeTicket = entityManager.find(TypeTicket.class, ticketDTO.getTypeTicket());

        return new Ticket(ticketDTO.getName(), ticketDTO.getDescription(),
                user, statusTicket, ticketDTO.getPriority(), ticketDTO.getTimeSpent(),
                ticketDTO.getTimeEstimated(), ticketDTO.getCreatedOnDate(), typeTicket);
    }

    @Override
    public TicketDTO covertToDTO(Ticket ticket) {

        return new TicketDTO(ticket.getName(), ticket.getDescription(),
                ticket.getUser().getId(), ticket.getStatus().getId(), ticket.getPriority(), ticket.getTimeSpent(),
                ticket.getTimeEstimated(), ticket.getCreatedOnDate(), ticket.getTypeTicket().getId());
    }

}
