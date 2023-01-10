package com.greatlearning.tickettrckr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "discription")
	private String discription;
	
	@Column(name = "date")
	private String createdon;
}
