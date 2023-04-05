package com.bookingMS.app.service;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.bookingMS.app.client.inventoryFeignClient;
import com.bookingMS.app.model.booking;
import com.bookingMS.app.model.businventory;
import com.bookingMS.app.repository.bookingrepository;

@Service
public class boookingService {

	@Autowired
	private bookingrepository bookRepo;

	@Autowired
	private Queue queue;
	
	@Autowired
	private Queue errorQueue;

	@Autowired
	private inventoryFeignClient invfeign;

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public List<booking> getAll() {
		return bookRepo.findAll();
	}
	
	public booking Book(@RequestBody booking req) {
		businventory businv = invfeign.getBusInventory(req.getBusNumber());
				if (businv != null) {
			if (businv.getAvailableseats() >= req.getNoOfSeats()) {
				req.setBookingStatus("pending");
				booking book = bookRepo.save(req);
				String message = String.valueOf(book.getBookingNumber()).concat("/")
						.concat(String.valueOf(book.getNoOfSeats()).concat("/")
						.concat(String.valueOf(book.getBusNumber())));
				jmsTemplate.convertAndSend(queue, message);
				return book;
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no seats available");
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no bus available");
		}

	}
	public booking getById(int id) {
		return bookRepo.findByBookingnumber(id);
	}
}
