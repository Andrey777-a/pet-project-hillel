package com.example.springhillel.repository.jparepository;

import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.StatusTicket;
import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.model.entity.TypeTicket;
import com.example.springhillel.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaTicketRepositoryImpl implements TicketRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Ticket> getAllTask() {
        TypedQuery<Ticket> taskAttribute = entityManager.createQuery("select u from Ticket u", Ticket.class);

        return taskAttribute.getResultList();
    }

    @Override
    public void createTask(TicketDTO ticketDTO) {

        User user = entityManager.find(User.class, ticketDTO.getAssignee());
        StatusTicket statusTicket = entityManager.find(StatusTicket.class, ticketDTO.getStatus());
        TypeTicket typeTicket = entityManager.find(TypeTicket.class, ticketDTO.getTypeTicket());

        Ticket ticket = new Ticket(ticketDTO.getName(), ticketDTO.getDescription(),
                user, statusTicket, ticketDTO.getPriority(), ticketDTO.getTimeSpent(),
                ticketDTO.getTimeEstimated(), ticketDTO.getCreatedOnDate(), typeTicket);

        entityManager.persist(ticket);

    }

    @Override
    public void updateTask(Ticket ticket) {

        entityManager.persist(ticket);

    }

    @Override
    public List<Ticket> getTaskUser(int user) {

        TypedQuery<Ticket> taskAttributeTypedQuery = entityManager.createQuery("select t from Ticket t", Ticket.class);

        for (Ticket ticket : taskAttributeTypedQuery.getResultList()){
            System.out.println(ticket.toString());
        }

        return taskAttributeTypedQuery.getResultList();
    }

    @Override
    public Ticket getTask(long id) {

        return entityManager.find(Ticket.class, id);
    }

    @Override
    public void deleteTask(long idTask) {

        Ticket ticket = entityManager.find(Ticket.class, idTask);
        StatusTicket statusTicket = entityManager.find(StatusTicket.class, 5L);

        ticket.setStatus(statusTicket);

        entityManager.persist(ticket);
    }

}
