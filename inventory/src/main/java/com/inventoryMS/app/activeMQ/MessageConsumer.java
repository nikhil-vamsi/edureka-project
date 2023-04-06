package com.inventoryMS.app.activeMQ;

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

import com.inventoryMS.app.model.Businventory;
import com.inventoryMS.app.repository.BusInventoryRepository;
import com.inventoryMS.app.service.Businventoryservice;

@Component
@EnableJms
public class MessageConsumer {

	@Autowired
	private BusInventoryRepository busInvRepo;

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	@Autowired
	private Queue errorqueue;


	@Autowired
	private Businventoryservice busInvService;
	
	
    @JmsListener(destination = "inventoryQueue")
    public void listener(String message){
    	try {
    	List<String> list = Arrays.asList(message.split("/"));
    	Businventory businv = busInvService
    			.getByBusNum(Integer.parseInt(list.get(2)));
    	businv.setAvailableseats(businv.getAvailableseats()-Integer.parseInt(list.get(1)));
    	Date currentDate = new Date();
    	businv.setLastupdateddate(currentDate);
//    	if(true) {
//    	throw new NullPointerException();
//    	}
    	busInvRepo.save(businv);
    	jmsTemplate.convertAndSend(queue, message);
    }
    	catch(Exception exc ) {
    		List<String> list = Arrays.asList(message.split("/"));
    		String errorMessage = "2".concat("/").concat(list.get(3))
    				.concat("/").concat(list.get(0));
    		jmsTemplate.convertAndSend(errorqueue, errorMessage);
    	}
    	}
}
