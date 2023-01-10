package com.greatlearning.tickettrckr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.greatlearning.tickettrckr.model.Ticket;
import com.greatlearning.tickettrckr.repository.TicketRepository;

public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository repository;
	
	@Override
	public List<Ticket> getAllTickets() {
		List<Ticket> allTickets = repository.findAll();
		return allTickets;
	}

	@Override
	public void saveOrUpdateTicket(Ticket tckt) {
		repository.save(tckt);
		
	}

	@Override
	public void deleteTicket(int number) {
		Ticket delTckt = getTicketByNumber(number);
		repository.delete(delTckt);
		
	}

	@Override
	public Ticket getTicketByNumber(int number) {
		Ticket tckt = repository.findById(number).get();
		return tckt;
	}

}