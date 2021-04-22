package com.example.springhillel.repository.jpacrudrepozitory;

import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.repository.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketPagingRepository extends AbstractRepository<Ticket> {

    @Query("select t from Ticket t order by 5")
    List<Ticket> getAllTicket();

}
