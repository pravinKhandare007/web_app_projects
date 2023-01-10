package com.greatlearning.tickettrckr.service;

import java.util.List;

import com.greatlearning.tickettrckr.model.Ticket;

public interface TicketService {
	public List<Ticket> getAllTickets();
	public void saveOrUpdateTicket(Ticket tckt);
	public void deleteTicket(int number);
	public Ticket getTicketByNumber(int number);
}