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

	@GetMapping("/tickets/search")
	public String home(Model model, String keyword) {
		if (keyword != null) {
			List<Ticket> list = ticketService.getTicketByKeyword(keyword);
			model.addAttribute("list", list);
		} else {
			List<Ticket> list = ticketService.getAllTickets();
			model.addAttribute("list", list);
		}
		return "ticket";
	}

	@GetMapping("/tickets")
	public String getAlltickets(Model model) {
		List<Ticket> tickets = ticketService.getAllTickets();
		model.addAttribute("list", tickets);
		return "ticket";
	}

	@GetMapping("/newTicket")
	public String newTicket(Model model) {
		Ticket newTicket = new Ticket();
		model.addAttribute("newticket", newTicket);
		return "createTicket";
	}

	@GetMapping("/ticket/edit/{id}")
	public String editTicket(Model model, @PathVariable("id") Integer id) {
		Ticket tck = ticketService.getTicketById(id);
		model.addAttribute("ticket", tck);
		return "edit_ticket";
	}

	@GetMapping("/ticket/delete/{id}")
	public String deleteTicket(@PathVariable("id") Integer id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}

	@PostMapping("/saveTickets")
	public String addTicket(@ModelAttribute(name = "newticket") Ticket tick) {
		ticketService.saveOrUpdateTicket(tick);
		return "redirect:/tickets";
	}

	@PostMapping("/tickets/{id}")
	public String updateTicket(@ModelAttribute(name = "ticket") Ticket tck, @PathVariable("id") Integer id) {
		Ticket existingTicket = ticketService.getTicketById(id);
		if (existingTicket.getId() == tck.getId()) {
			existingTicket.setTitle(tck.getTitle());
			existingTicket.setDiscription(tck.getDiscription());
			existingTicket.setCreatedon(tck.getCreatedon());
		}
		ticketService.saveOrUpdateTicket(existingTicket);
		return "redirect:/tickets";
	}
}
