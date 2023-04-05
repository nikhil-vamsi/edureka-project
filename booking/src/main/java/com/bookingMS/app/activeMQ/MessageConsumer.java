package com.bookingMS.app.activeMQ;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.bookingMS.app.model.Passenger;
import com.bookingMS.app.model.booking;
import com.bookingMS.app.repository.bookingrepository;
import com.bookingMS.app.repository.passengerRepository;
import com.bookingMS.app.service.boookingService;

@Component
@EnableJms
public class MessageConsumer {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private bookingrepository bookRepo;
	
	@Autowired
	private passengerRepository passengerRepo;
	
	@Autowired
	private boookingService bookService;
	
	@Autowired
	private Queue errorQueue;
	
	@Autowired
	private Queue queue;
    @JmsListener(destination = "bookingQueue")
    public void listener(String message){
    	List<String> list = Arrays.asList(message.split("/"));
    	booking book = bookService.getById(Integer.parseInt(list.get(0)));
    	book.setBookingStatus("confirmed");
    	bookRepo.save(book);
    	for(int i=0;i<Integer.parseInt(list.get(1));i++) {
    		Passenger p = new Passenger();
    		p.setBooking_number(Integer.parseInt(list.get(0)));
    		passengerRepo.save(p);
    	}
    }
    
    @JmsListener(destination = "errorQueue")
    public void listener2(String message){
    	List<String> list = Arrays.asList(message.split("/"));
    	booking book = bookService.getById(Integer.parseInt(list.get(0)));
    	book.setBookingStatus("failed");
    	bookRepo.save(book);
    }
}
