package com.greatlearning.tickettrckr.repository;

import com.greatlearning.tickettrckr.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
