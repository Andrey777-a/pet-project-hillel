package com.example.springhillel.repository.jpacrudrepozitory;

import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.repository.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPagingRepository extends AbstractRepository<Ticket> {

    @Override
    @Query("select t from Ticket t order by 2")
    Page<Ticket> findAll(Pageable pageable);

}
