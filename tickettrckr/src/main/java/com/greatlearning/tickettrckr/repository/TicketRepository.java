package com.greatlearning.tickettrckr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.tickettrckr.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	@Query(value = "select * from tickets t where t.ticket_title like %:keyword% or t.ticket_discription like %:keyword%", nativeQuery = true)
	List<Ticket> findByKeyword(@Param("keyword") String keyword);
}
