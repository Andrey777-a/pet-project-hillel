package com.example.springhillel.config;

import com.example.springhillel.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface TicketTest extends JpaRepository<Ticket, Long> {
}
