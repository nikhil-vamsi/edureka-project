
package com.bookingMS.app.controller;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookingMS.app.model.Passenger;
import com.bookingMS.app.model.Booking;
import com.bookingMS.app.repository.PassengerRepository;
import com.bookingMS.app.service.boookingService;

@RestController
public class BookingController {

	@Autowired
	private boookingService bookService;
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@GetMapping("/getBookings")
	public List<Booking> getAll() {
		return bookService.getAll();
	}
	
	@GetMapping("/getBookingById/{Id}")
	public Booking getById(@PathVariable int id) {
		return bookService.getById(id);
	}


	@PostMapping("/Book")
	public String Book(@RequestBody Booking req){
		return bookService.Book(req);

	}
	@GetMapping("/getPassengers")
	public List<Passenger> getpassengers() {
		return passengerRepo.findAll();

	}

}
