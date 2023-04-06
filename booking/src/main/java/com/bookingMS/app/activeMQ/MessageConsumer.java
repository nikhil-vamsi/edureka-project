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

import com.bookingMS.app.client.PaymentFeignClient;
import com.bookingMS.app.model.Passenger;
import com.bookingMS.app.model.Booking;
import com.bookingMS.app.repository.Bookingrepository;
import com.bookingMS.app.repository.PassengerRepository;
import com.bookingMS.app.service.boookingService;

@Component
@EnableJms
public class MessageConsumer {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Bookingrepository bookRepo;
	
	@Autowired 
	private PaymentFeignClient paymentFeign;
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private boookingService bookService;
	
	@Autowired
	private Queue errorQueue;
	
	@Autowired
	private Queue queue;
    @JmsListener(destination = "bookingQueue")
    public void listener(String message){
    	List<String> list = Arrays.asList(message.split("/"));
    	Booking book = bookService.getById(Integer.parseInt(list.get(0)));
    	book.setBookingstatus("confirmed");
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
    	if(Integer.parseInt(list.get(0))==1) {
    		/*payment failed */
    		bookRepo.deleteById(Integer.parseInt(list.get(1)));
    	}
    	
    	if(Integer.parseInt(list.get(0))==2) {
    		/*inventory failed */
    		paymentFeign.delete(Integer.parseInt(list.get(1)));
    		bookRepo.deleteById(Integer.parseInt(list.get(2)));
    	}
    }
}
