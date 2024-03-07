package com.lcwsankalp.movieticket.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lcwsankalp.movieticket.dto.MovieTicketAcknowledgement;
import com.lcwsankalp.movieticket.dto.MovieTicketRequest;
import com.lcwsankalp.movieticket.service.MovieTicketService;

@RestController
public class MovieTicketController {
	
	@Autowired
	MovieTicketService service;
	
	@PostMapping("/bookMovieTicket")
	public MovieTicketAcknowledgement bookTicket(@RequestBody MovieTicketRequest request) {
		return service.bookMovieTicket(request);
	}
	
	

}
