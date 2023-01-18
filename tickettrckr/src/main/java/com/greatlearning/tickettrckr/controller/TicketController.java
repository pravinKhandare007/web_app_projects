package com.greatlearning.tickettrckr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.greatlearning.tickettrckr.model.Ticket;
import com.greatlearning.tickettrckr.service.TicketServiceImpl;

@Controller
public class TicketController {
	
	@Autowired
	TicketServiceImpl ticketService;
	
	@GetMapping("/tickets")
	public String getAlltickets(Model model){
		List<Ticket> tickets = ticketService.getAllTickets();
//		for(Ticket tck: tickets) {
//			System.out.println(tck.id);
//		}
		model.addAttribute("list",tickets);
		return "ticket";
	}
	
	@GetMapping("/newTicket")
	public String newTicket(Model model) {
		Ticket newTicket = new Ticket();
		model.addAttribute("newticket",newTicket);
		return "createTicket";
	}
	
	@GetMapping("/ticket/edit/{id}")
	public String editTicket(Model model,@PathVariable("id") Integer id){
		Ticket tck = ticketService.getTicketByNumber(id);
		model.addAttribute("ticket",tck);
		return "edit_ticket";
	
	}
	
	@PostMapping("/saveTickets")
	public String addTicket(@ModelAttribute(name = "newticket") Ticket tick) {
		ticketService.saveOrUpdateTicket(tick);
		return "redirect:/tickets";
	}
	
	@PostMapping("/tickets/{id}")
	public String updateTicket(@ModelAttribute(name = "ticket") Ticket tck, @PathVariable("id") Integer id) {
		Ticket existingTicket= ticketService.getTicketByNumber(id);
		if(existingTicket.getId()== tck.getId()) {
			existingTicket.setTitle(tck.getTitle());
			existingTicket.setDiscription(tck.getDiscription());
			existingTicket.setCreatedon(tck.getCreatedon());
		}
		ticketService.saveOrUpdateTicket(existingTicket);
		return "redirect:/tickets";
	}
}
