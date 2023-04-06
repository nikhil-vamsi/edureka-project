package com.bookingMS.app.service;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.List;

import javax.jms.Queue;
import javax.management.relation.RelationTypeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.bookingMS.app.client.InventoryFeignClient;
import com.bookingMS.app.model.Booking;
import com.bookingMS.app.model.Businventory;
import com.bookingMS.app.repository.Bookingrepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class boookingService {

	@Autowired
	private Bookingrepository bookRepo;

	@Autowired
	private Queue queue;
	
	@Autowired
	private Queue errorQueue;

	@Autowired
	private InventoryFeignClient invfeign;

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public List<Booking> getAll() {
		return bookRepo.findAll();
	}
	
	public String invfeignfail(Booking req,Throwable th){
		
		return "Booking failed due to  ms availability";
	}
	@CircuitBreaker(name="invfeigns",fallbackMethod="invfeignfail")
	public String Book(@RequestBody Booking req){
		Businventory businv = invfeign.getBusInventory(req.getBusnumber());
		if (businv != null) {
			if (businv.getAvailableseats() >= req.getNoofseats()) {
				req.setBookingstatus("pending");
				Booking book = bookRepo.save(req);
				String message = String.valueOf(book.getBookingnumber()).concat("/")
						.concat(String.valueOf(book.getNoofseats()).concat("/")
						.concat(String.valueOf(book.getBusnumber())));
				jmsTemplate.convertAndSend(queue, message);
				Booking book2 = bookRepo.findByBookingnumber(book.getBookingnumber());
				return "booking completed";
			} else {
				return "seats not available";
			}
		} else {
			return "bus not available";
		}

	}
	public Booking getById(int id) {
		return bookRepo.findByBookingnumber(id);
	}
}
