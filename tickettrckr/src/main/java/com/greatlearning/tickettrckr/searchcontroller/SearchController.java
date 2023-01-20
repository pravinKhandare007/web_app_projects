package com.greatlearning.tickettrckr.searchcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
	
	@GetMapping("/tickets/search")
	public String searchTickets(Model model) {
		
		 
		
		return null;
		
	}
	
}
