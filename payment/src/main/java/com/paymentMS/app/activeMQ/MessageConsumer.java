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

import com.paymentMS.app.controller.paymentController;
import com.paymentMS.app.model.payment;
import com.paymentMS.app.service.paymentService;

@Component
@EnableJms
public class MessageConsumer {


	@Autowired 
	paymentController pay;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;

	
	@Autowired
	private paymentService payService;
	
	
    @JmsListener(destination = "paymentQueue")
    public void listener(String message){
    	List<String> list = Arrays.asList(message.split("/"));
    	payment p = new payment();
    	p.setbookingnumber(Integer.parseInt(list.get(0)));
    	Date currentDate = new Date();
    	p.setdateofpayment(currentDate);
    	payService.savePayment(p);
    	jmsTemplate.convertAndSend(queue, message);
    }
}
