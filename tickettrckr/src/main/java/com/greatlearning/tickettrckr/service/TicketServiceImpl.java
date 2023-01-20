package com.greatlearning.tickettrckr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tickettrckr.model.Ticket;
import com.greatlearning.tickettrckr.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

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
	public void deleteTicketById(int number) {
		Ticket delTckt = getTicketById(number);
		repository.delete(delTckt);

	}

	@Override
	public Ticket getTicketById(int number) {
		Ticket tckt = repository.findById(number).get();
		return tckt;
	}

	@Override
	public List<Ticket> getTicketByKeyword(String keyword) {
		return repository.findByKeyword(keyword);
	}

}
