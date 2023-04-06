package com.paymentMS.app.activeMQ;

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

import com.paymentMS.app.controller.PaymentController;
import com.paymentMS.app.model.Payment;
import com.paymentMS.app.service.PaymentService;

@Component
@EnableJms
public class MessageConsumer {


	@Autowired 
	PaymentController pay;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	@Autowired
	private Queue errorqueue;

	
	@Autowired
	private PaymentService payService;
	
	
    @JmsListener(destination = "paymentQueue")
    public void listener(String message){
    	try {
    	List<String> list = Arrays.asList(message.split("/"));
    	Payment p = new Payment();
    	p.setbookingnumber(Integer.parseInt(list.get(0)));
    	Date currentDate = new Date();
    	p.setdateofpayment(currentDate);
    	if(true) {
        	throw new NullPointerException();
        	}
    	Payment paymentSaved = payService.savePayment(p);
    	String newMessage = message.concat("/").concat(String.valueOf(paymentSaved.getpaymentid()));
    	jmsTemplate.convertAndSend(queue, newMessage);
    }
    	catch(Exception exc) {
    		List<String> list = Arrays.asList(message.split("/"));
    		String errorMessage = "1".concat("/").concat(list.get(0));
    		jmsTemplate.convertAndSend(errorqueue, errorMessage);
    	}
    	}
}
