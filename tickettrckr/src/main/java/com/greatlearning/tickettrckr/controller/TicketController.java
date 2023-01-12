package com.greatlearning.tickettrckr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tickettrckr.model.Ticket;
import com.greatlearning.tickettrckr.service.TicketServiceImpl;

@Controller
public class TicketController {
	
	@Autowired
	TicketServiceImpl ticketService;
	
	@GetMapping("tickettrckr/tickets")
	public String getAlltickets(Model model){
		List<Ticket> tickets = ticketService.getAllTickets();
		model.addAttribute("list",tickets);
		return "employee";
	}
	
	@GetMapping("tickettrckr/tickettrckr/newTicket")
	public String newTicket(Model model) {
		Ticket newTicket = new Ticket();
		model.addAttribute("newticket",newTicket);
		return "create_employee";
	}
	
	@PostMapping("tickettrckr/tickets")
	public String addTicket(@ModelAttribute(name = "newticket") Ticket tick) {
		ticketService.saveOrUpdateTicket(tick);
		return "redirect:/tickettrckr/tickets";
	}
}
